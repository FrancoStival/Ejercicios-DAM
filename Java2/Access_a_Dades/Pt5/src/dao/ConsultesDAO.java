package dao;

import db.Connexio;
import java.sql.*;

public class ConsultesDAO {


    public void llistarComandesPerClient(int clientId) throws SQLException {
        String sql = "SELECT c.id AS comanda_id, c.data, c.total, " +
                "lc.id AS linia_id, lc.producte_id, lc.quantitat, lc.preuUnitari, p.nom AS producte_nom " +
                "FROM Comandes c " +
                "LEFT JOIN LiniesComanda lc ON c.id = lc.comanda_id " +
                "LEFT JOIN Productes p ON lc.producte_id = p.id " +
                "WHERE c.client_id = ? " +
                "ORDER BY c.id, lc.id";

        try (Connection conn = Connexio.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, clientId);
            try (ResultSet rs = ps.executeQuery()) {
                int ultimaComanda = -1;
                while (rs.next()) {
                    int comandaId = rs.getInt("comanda_id");
                    if (comandaId != ultimaComanda) {
                        System.out.println("Comanda ID: " + comandaId + "  Data: " + rs.getTimestamp("data") + "  Total: " + rs.getBigDecimal("total"));
                        ultimaComanda = comandaId;
                    }
                    int liniaId = rs.getInt("linia_id");
                    if (liniaId != 0) {
                        System.out.println("  Linia " + liniaId + " - Producte: " + rs.getString("producte_nom")
                                + " (id:" + rs.getInt("producte_id") + ") Quantitat: " + rs.getInt("quantitat")
                                + " PreuUnitari: " + rs.getBigDecimal("preuUnitari"));
                    }
                }
            }
        }
    }

    public void mostrarTotalsComandes() throws SQLException {
        String sql = "SELECT id, client_id, data, total FROM Comandes ORDER BY data DESC";
        try (Connection conn = Connexio.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println("Comanda id:" + rs.getInt("id") + " client_id:" + rs.getInt("client_id")
                        + " data:" + rs.getTimestamp("data") + " total:" + rs.getBigDecimal("total"));
            }
        }
    }
}
