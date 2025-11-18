package dao;

import db.Connexio;
import model.Comanda;
import model.LiniaComanda;
import model.Descompte;
import model.Producte;

import java.sql.*;
import java.math.BigDecimal;
import java.util.List;

public class ComandaDAO {

    private final ProducteDAO producteDAO = new ProducteDAO();
    private final DescompteDAO descompteDAO = new DescompteDAO();

    /**
     * Crea una comanda amb transacció.
     * - comprova estoc i decrementa
     * - insereix en Comandes, LiniesComanda
     * - calcula total
     * - després de inserir línies crea savepoint i intenta aplicar descomptes.
     * Si falla l'aplicació de descomptes fa rollback(savepoint) i guarda tiquet sense descompte.
     */
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

            // 1) Comprovar estoc per cada linia i decrementar
            List<LiniaComanda> linies = comanda.getLinies();
            for (LiniaComanda l : linies) {
                // comprovar existència i estoc
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

            // 2) Insertar comanda (total temporal 0)
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

            // 3) Insertar línies i calcular total inicial
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

            // Actualitzar total temporal
            try (PreparedStatement ps = conn.prepareStatement(updateComandaTotalSQL)) {
                ps.setBigDecimal(1, total);
                ps.setInt(2, comandaId);
                ps.executeUpdate();
            }

            // 4) savepoint abans d'aplicar descomptes
            afterLines = conn.setSavepoint("DespresLinies");

            // 5) intentar aplicar descomptes
            BigDecimal totalAmbDescompte = total;
            try {
                for (LiniaComanda l : linies) {
                    Descompte d = descompteDAO.trobarPerProducte(l.getProducteId());
                    if (d != null) {
                        if ("%".equals(d.getTipus())) {
                            // aplicam percentatge sobre línia
                            BigDecimal liniaTotal = l.getPreuUnitari().multiply(new BigDecimal(l.getQuantitat()));
                            BigDecimal desc = liniaTotal.multiply(d.getValor()).divide(new BigDecimal("100"));
                            totalAmbDescompte = totalAmbDescompte.subtract(desc);
                        } else {
                            // € per unitat? assumim valor en total per línia = valor * quantitat
                            BigDecimal desc = d.getValor().multiply(new BigDecimal(l.getQuantitat()));
                            totalAmbDescompte = totalAmbDescompte.subtract(desc);
                        }
                    }
                }

                // assegurar no negatiu
                if (totalAmbDescompte.compareTo(BigDecimal.ZERO) < 0) totalAmbDescompte = BigDecimal.ZERO;

                // Actualitzar total amb descompte
                try (PreparedStatement ps = conn.prepareStatement(updateComandaTotalSQL)) {
                    ps.setBigDecimal(1, totalAmbDescompte);
                    ps.setInt(2, comandaId);
                    ps.executeUpdate();
                }
            } catch (Exception ex) {
                // rollback al savepoint i deixar el total sense descomptes
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
