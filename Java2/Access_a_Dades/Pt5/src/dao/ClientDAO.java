package dao;

import db.Connexio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Client;

public class ClientDAO {

    public void inserir(Client cte) throws SQLException {
        String sql = "INSERT INTO Clients (nom, correu) VALUES (?, ?)";
        try (Connection c = Connexio.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cte.getNom());
            ps.setString(2, cte.getCorreu());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) cte.setId(rs.getInt(1));
            }
        }
    }

    public List<Client> llistar() throws SQLException {
        String sql = "SELECT id, nom, correu FROM Clients";
        List<Client> l = new ArrayList<>();
        try (Connection c = Connexio.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                l.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("correu")));
            }
        }
        return l;
    }

    public void actualitzar(Client client) throws SQLException {
        String sql = "UPDATE Clients SET nom = ?, correu = ? WHERE id = ?";
        try (Connection c = Connexio.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, client.getNom());
            ps.setString(2, client.getCorreu());
            ps.setInt(3, client.getId());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM Clients WHERE id = ?";
        try (Connection c = Connexio.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Client trobarPerId(int id) throws SQLException {
        String sql = "SELECT id, nom, correu FROM Clients WHERE id = ?";
        try (Connection c = Connexio.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("correu"));
            }
        }
        return null;
    }
}
