package com.mycompany.gestion.academica.dao;

import com.mycompany.gestion.academica.modelo.Profesor;
import com.mycompany.gestion.academica.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {

    public List<Profesor> listar() throws SQLException {
        List<Profesor> lista = new ArrayList<>();
        String sql = "SELECT id_p, nom_p, dir_p, tel_p, profesion FROM Profesores ORDER BY id_p";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    public Profesor buscarPorId(int idP) throws SQLException {
        String sql = "SELECT id_p, nom_p, dir_p, tel_p, profesion FROM Profesores WHERE id_p = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idP);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }
        }
        return null;
    }

    public int insertar(Profesor profesor) throws SQLException {
        String sql = "INSERT INTO Profesores (nom_p, dir_p, tel_p, profesion) VALUES (?, ?, ?, ?) RETURNING id_p";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, profesor.getNomP());
            ps.setString(2, profesor.getDirP());
            ps.setString(3, profesor.getTelP());
            ps.setString(4, profesor.getProfesion());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public void actualizar(Profesor profesor) throws SQLException {
        String sql = "UPDATE Profesores SET nom_p = ?, dir_p = ?, tel_p = ?, profesion = ? WHERE id_p = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, profesor.getNomP());
            ps.setString(2, profesor.getDirP());
            ps.setString(3, profesor.getTelP());
            ps.setString(4, profesor.getProfesion());
            ps.setInt(5, profesor.getIdP());
            ps.executeUpdate();
        }
    }

    public void eliminar(int idP) throws SQLException {
        String sql = "DELETE FROM Profesores WHERE id_p = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idP);
            ps.executeUpdate();
        }
    }

    private Profesor mapear(ResultSet rs) throws SQLException {
        Profesor p = new Profesor();
        p.setIdP(rs.getInt("id_p"));
        p.setNomP(rs.getString("nom_p"));
        p.setDirP(rs.getString("dir_p"));
        p.setTelP(rs.getString("tel_p"));
        p.setProfesion(rs.getString("profesion"));
        return p;
    }
}
