package dao;

import db.Connexio;
import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
import model.Comanda;
import model.Descompte;
import model.LiniaComanda;
import model.Producte;

public class ComandaDAO {

    private final ProducteDAO producteDAO = new ProducteDAO();
    private final DescompteDAO descompteDAO = new DescompteDAO();

    public void crearComanda(Comanda comanda) throws SQLException {
        String insertComandaSQL = "INSERT INTO Comandes (client_id, total) VALUES (?, ?)";
        String insertLiniaSQL = "INSERT INTO LiniesComanda (comanda_id, producte_id, quantitat, preuUnitari) VALUES (?, ?, ?, ?)";
        String updateProducteStockSQL = "UPDATE Productes SET estoc = estoc - ? WHERE id = ? AND estoc >= ?";
        String updateComandaTotalSQL = "UPDATE Comandes SET total = ? WHERE id = ?";

        Connection conn = null;
        Savepoint afterLines = null;
        try {
            conn = Connexio.getConnection();
            conn.setAutoCommit(false);

            List<LiniaComanda> linies = comanda.getLinies();
            for (LiniaComanda l : linies) {
                Producte p = producteDAO.trobarPerId(l.getProducteId());
                if (p == null) throw new SQLException("Producte id " + l.getProducteId() + " no existeix.");
                if (p.getEstoc() < l.getQuantitat()) throw new SQLException("Estoc insuficient per producte id " + l.getProducteId());

                try (PreparedStatement psUpd = conn.prepareStatement(updateProducteStockSQL)) {
                    psUpd.setInt(1, l.getQuantitat());
                    psUpd.setInt(2, l.getProducteId());
                    psUpd.setInt(3, l.getQuantitat());
                    int updated = psUpd.executeUpdate();
                    if (updated == 0) throw new SQLException("Estoc insuficient (race) per producte id " + l.getProducteId());
                }
            }

            int comandaId;
            try (PreparedStatement ps = conn.prepareStatement(insertComandaSQL, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, comanda.getClientId());
                ps.setBigDecimal(2, BigDecimal.ZERO);
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) comandaId = rs.getInt(1);
                    else throw new SQLException("No s'ha obtingut id de comanda.");
                }
            }

            BigDecimal total = BigDecimal.ZERO;
            try (PreparedStatement psLinia = conn.prepareStatement(insertLiniaSQL)) {
                for (LiniaComanda l : linies) {
                    psLinia.setInt(1, comandaId);
                    psLinia.setInt(2, l.getProducteId());
                    psLinia.setInt(3, l.getQuantitat());
                    psLinia.setBigDecimal(4, l.getPreuUnitari());
                    psLinia.executeUpdate();

                    BigDecimal liniaTotal = l.getPreuUnitari().multiply(new BigDecimal(l.getQuantitat()));
                    total = total.add(liniaTotal);
                }
            }

            try (PreparedStatement ps = conn.prepareStatement(updateComandaTotalSQL)) {
                ps.setBigDecimal(1, total);
                ps.setInt(2, comandaId);
                ps.executeUpdate();
            }

            afterLines = conn.setSavepoint("DespresLinies");

            BigDecimal totalAmbDescompte = total;
            try {
                for (LiniaComanda l : linies) {
                    Descompte d = descompteDAO.trobarPerProducte(l.getProducteId());
                    if (d != null) {
                        if ("%".equals(d.getTipus())) {
                            BigDecimal liniaTotal = l.getPreuUnitari().multiply(new BigDecimal(l.getQuantitat()));
                            BigDecimal desc = liniaTotal.multiply(d.getValor()).divide(new BigDecimal("100"));
                            totalAmbDescompte = totalAmbDescompte.subtract(desc);
                        } else {
                            BigDecimal desc = d.getValor().multiply(new BigDecimal(l.getQuantitat()));
                            totalAmbDescompte = totalAmbDescompte.subtract(desc);
                        }
                    }
                }

                if (totalAmbDescompte.compareTo(BigDecimal.ZERO) < 0) totalAmbDescompte = BigDecimal.ZERO;

                try (PreparedStatement ps = conn.prepareStatement(updateComandaTotalSQL)) {
                    ps.setBigDecimal(1, totalAmbDescompte);
                    ps.setInt(2, comandaId);
                    ps.executeUpdate();
                }
            } catch (SQLException ex) {
                conn.rollback(afterLines);
                try (PreparedStatement ps = conn.prepareStatement(updateComandaTotalSQL)) {
                    ps.setBigDecimal(1, total);
                    ps.setInt(2, comandaId);
                    ps.executeUpdate();
                }
            }

            conn.commit();
            comanda.setId(comandaId);
            comanda.setTotal(totalAmbDescompte);
        } catch (SQLException ex) {
            if (conn != null) conn.rollback();
            throw ex;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }
}
