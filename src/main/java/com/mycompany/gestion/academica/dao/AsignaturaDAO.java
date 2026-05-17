package com.mycompany.gestion.academica.dao;

import com.mycompany.gestion.academica.modelo.Asignatura;
import com.mycompany.gestion.academica.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaDAO {

    public List<Asignatura> listar() throws SQLException {
        List<Asignatura> lista = new ArrayList<>();
        String sql = "SELECT cod_a, nom_a, int_h, creditos FROM Asignaturas ORDER BY cod_a";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    public Asignatura buscarPorId(int codA) throws SQLException {
        String sql = "SELECT cod_a, nom_a, int_h, creditos FROM Asignaturas WHERE cod_a = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codA);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }
        }
        return null;
    }

    public int insertar(Asignatura asignatura) throws SQLException {
        String sql = "INSERT INTO Asignaturas (nom_a, int_h, creditos) VALUES (?, ?, ?) RETURNING cod_a";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, asignatura.getNomA());
            if (asignatura.getIntH() > 0) {
                ps.setInt(2, asignatura.getIntH());
            } else {
                ps.setNull(2, java.sql.Types.INTEGER);
            }
            ps.setDouble(3, asignatura.getCreditos());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public void actualizar(Asignatura asignatura) throws SQLException {
        String sql = "UPDATE Asignaturas SET nom_a = ?, int_h = ?, creditos = ? WHERE cod_a = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, asignatura.getNomA());
            if (asignatura.getIntH() > 0) {
                ps.setInt(2, asignatura.getIntH());
            } else {
                ps.setNull(2, java.sql.Types.INTEGER);
            }
            ps.setDouble(3, asignatura.getCreditos());
            ps.setInt(4, asignatura.getCodA());
            ps.executeUpdate();
        }
    }

    public void eliminar(int codA) throws SQLException {
        String sql = "DELETE FROM Asignaturas WHERE cod_a = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codA);
            ps.executeUpdate();
        }
    }

    private Asignatura mapear(ResultSet rs) throws SQLException {
        Asignatura a = new Asignatura();
        a.setCodA(rs.getInt("cod_a"));
        a.setNomA(rs.getString("nom_a"));
        int intH = rs.getInt("int_h");
        a.setIntH(rs.wasNull() ? 0 : intH);
        a.setCreditos(rs.getDouble("creditos"));
        return a;
    }
}
