package com.mycompany.gestion.academica.dao;

import com.mycompany.gestion.academica.modelo.Carrera;
import com.mycompany.gestion.academica.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarreraDAO {

    public List<Carrera> listar() throws SQLException {
        List<Carrera> lista = new ArrayList<>();
        String sql = "SELECT id_carr, nom_carr, reg_calif FROM Carreras ORDER BY id_carr";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    public Carrera buscarPorId(int id) throws SQLException {
        String sql = "SELECT id_carr, nom_carr, reg_calif FROM Carreras WHERE id_carr = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }
        }
        return null;
    }

    public int insertar(Carrera carrera) throws SQLException {
        String sql = "INSERT INTO Carreras (nom_carr, reg_calif) VALUES (?, ?) RETURNING id_carr";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, carrera.getNomCarr());
            ps.setString(2, carrera.getRegCalif());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public void actualizar(Carrera carrera) throws SQLException {
        String sql = "UPDATE Carreras SET nom_carr = ?, reg_calif = ? WHERE id_carr = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, carrera.getNomCarr());
            ps.setString(2, carrera.getRegCalif());
            ps.setInt(3, carrera.getIdCarr());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM Carreras WHERE id_carr = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Carrera mapear(ResultSet rs) throws SQLException {
        Carrera c = new Carrera();
        c.setIdCarr(rs.getInt("id_carr"));
        c.setNomCarr(rs.getString("nom_carr"));
        c.setRegCalif(rs.getString("reg_calif"));
        return c;
    }
}
