package com.mycompany.gestion.academica.dao;

import com.mycompany.gestion.academica.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequiereDAO {

    public static class RequiereDetalle {
        private int codA;
        private int codAR;
        private String nomA;
        private String nomPrerrequisito;

        public int getCodA() { return codA; }
        public int getCodAR() { return codAR; }
        public String getNomA() { return nomA; }
        public String getNomPrerrequisito() { return nomPrerrequisito; }
    }

    public List<RequiereDetalle> listar() throws SQLException {
        List<RequiereDetalle> lista = new ArrayList<>();
        String sql = """
            SELECT r.cod_a, r.cod_a_r, a.nom_a AS nom_a, ar.nom_a AS nom_prerrequisito
            FROM Requiere r
            JOIN Asignaturas a ON r.cod_a = a.cod_a
            JOIN Asignaturas ar ON r.cod_a_r = ar.cod_a
            ORDER BY a.nom_a, ar.nom_a
            """;
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                RequiereDetalle d = new RequiereDetalle();
                d.codA = rs.getInt("cod_a");
                d.codAR = rs.getInt("cod_a_r");
                d.nomA = rs.getString("nom_a");
                d.nomPrerrequisito = rs.getString("nom_prerrequisito");
                lista.add(d);
            }
        }
        return lista;
    }

    public void insertar(int codA, int codAR) throws SQLException {
        String sql = "INSERT INTO Requiere (cod_a, cod_a_r) VALUES (?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codA);
            ps.setInt(2, codAR);
            ps.executeUpdate();
        }
    }

    public void eliminar(int codA, int codAR) throws SQLException {
        String sql = "DELETE FROM Requiere WHERE cod_a = ? AND cod_a_r = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codA);
            ps.setInt(2, codAR);
            ps.executeUpdate();
        }
    }
}
