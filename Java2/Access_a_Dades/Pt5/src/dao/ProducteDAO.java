package dao;

import db.Connexio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Producte;

public class ProducteDAO {

    public void inserir(Producte p) throws SQLException {
        String sql = "INSERT INTO Productes (nom, preu, estoc) VALUES (?, ?, ?)";
        try (Connection c = Connexio.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNom());
            ps.setBigDecimal(2, p.getPreu());
            ps.setInt(3, p.getEstoc());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) p.setId(rs.getInt(1));
            }
        }
    }

    public List<Producte> llistar() throws SQLException {
        String sql = "SELECT id, nom, preu, estoc FROM Productes";
        List<Producte> l = new ArrayList<>();
        try (Connection c = Connexio.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producte p = new Producte(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getBigDecimal("preu"),
                        rs.getInt("estoc")
                );
                l.add(p);
            }
        }
        return l;
    }

    public void actualitzar(Producte p) throws SQLException {
        String sql = "UPDATE Productes SET nom = ?, preu = ?, estoc = ? WHERE id = ?";
        try (Connection c = Connexio.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.getNom());
            ps.setBigDecimal(2, p.getPreu());
            ps.setInt(3, p.getEstoc());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM Productes WHERE id = ?";
        try (Connection c = Connexio.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Producte trobarPerId(int id) throws SQLException {
        String sql = "SELECT id, nom, preu, estoc FROM Productes WHERE id = ?";
        try (Connection c = Connexio.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Producte(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getBigDecimal("preu"),
                            rs.getInt("estoc")
                    );
                }
            }
        }
        return null;
    }
}
