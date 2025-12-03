package dao;

import db.Connexio;
import model.Descompte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class DescompteDAO {

    public void inserir(Descompte d) throws SQLException {
        String sql = "INSERT INTO Descomptes (producte_id, tipus, valor) VALUES (?, ?, ?)";
        try (Connection c = Connexio.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, d.getProducteId());
            ps.setString(2, d.getTipus());
            ps.setBigDecimal(3, d.getValor());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) d.setId(rs.getInt(1));
            }
        }
    }

    public List<Descompte> llistar() throws SQLException {
        String sql = "SELECT id, producte_id, tipus, valor FROM Descomptes";
        List<Descompte> l = new ArrayList<>();
        try (Connection c = Connexio.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                l.add(new Descompte(
                        rs.getInt("id"),
                        rs.getInt("producte_id"),
                        rs.getString("tipus"),
                        rs.getBigDecimal("valor")
                ));
            }
        }
        return l;
    }

    public Descompte trobarPerProducte(int producteId) throws SQLException {
        String sql = "SELECT id, producte_id, tipus, valor FROM Descomptes WHERE producte_id = ?";
        try (Connection c = Connexio.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, producteId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Descompte(
                            rs.getInt("id"),
                            rs.getInt("producte_id"),
                            rs.getString("tipus"),
                            rs.getBigDecimal("valor")
                    );
                }
            }
        }
        return null;
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM Descomptes WHERE id = ?";
        try (Connection c = Connexio.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
