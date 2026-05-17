package com.mycompany.gestion.academica.dao;

import com.mycompany.gestion.academica.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncluyeDAO {

    public static class IncluyeDetalle {
        private int idCarr;
        private int codA;
        private String nomCarr;
        private String nomA;

        public int getIdCarr() { return idCarr; }
        public int getCodA() { return codA; }
        public String getNomCarr() { return nomCarr; }
        public String getNomA() { return nomA; }
    }

    public List<IncluyeDetalle> listar() throws SQLException {
        List<IncluyeDetalle> lista = new ArrayList<>();
        String sql = """
            SELECT i.id_carr, i.cod_a, c.nom_carr, a.nom_a
            FROM Incluye i
            JOIN Carreras c ON i.id_carr = c.id_carr
            JOIN Asignaturas a ON i.cod_a = a.cod_a
            ORDER BY c.nom_carr, a.nom_a
            """;
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                IncluyeDetalle d = new IncluyeDetalle();
                d.idCarr = rs.getInt("id_carr");
                d.codA = rs.getInt("cod_a");
                d.nomCarr = rs.getString("nom_carr");
                d.nomA = rs.getString("nom_a");
                lista.add(d);
            }
        }
        return lista;
    }

    public void insertar(int idCarr, int codA) throws SQLException {
        String sql = "INSERT INTO Incluye (id_carr, cod_a) VALUES (?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCarr);
            ps.setInt(2, codA);
            ps.executeUpdate();
        }
    }

    public void eliminar(int idCarr, int codA) throws SQLException {
        String sql = "DELETE FROM Incluye WHERE id_carr = ? AND cod_a = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCarr);
            ps.setInt(2, codA);
            ps.executeUpdate();
        }
    }
}
