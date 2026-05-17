package com.mycompany.gestion.academica.dao;

import com.mycompany.gestion.academica.modelo.Carrera;
import com.mycompany.gestion.academica.modelo.Estudiante;
import com.mycompany.gestion.academica.util.ConexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    public List<Estudiante> listar() throws SQLException {
        List<Estudiante> lista = new ArrayList<>();
        String sql = """
            SELECT e.cod_e, e.nom_e, e.dir_e, e.tel_e, e.fech_nac, e.id_carr,
                   c.nom_carr
            FROM Estudiantes e
            LEFT JOIN Carreras c ON e.id_carr = c.id_carr
            ORDER BY e.cod_e
            """;
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    public Estudiante buscarPorId(int codE) throws SQLException {
        String sql = """
            SELECT e.cod_e, e.nom_e, e.dir_e, e.tel_e, e.fech_nac, e.id_carr,
                   c.nom_carr
            FROM Estudiantes e
            LEFT JOIN Carreras c ON e.id_carr = c.id_carr
            WHERE e.cod_e = ?
            """;
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codE);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }
        }
        return null;
    }

    public int insertar(Estudiante estudiante) throws SQLException {
        String sql = "INSERT INTO Estudiantes (nom_e, dir_e, tel_e, fech_nac, id_carr) VALUES (?, ?, ?, ?, ?) RETURNING cod_e";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            bindEstudiante(ps, estudiante);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public void actualizar(Estudiante estudiante) throws SQLException {
        String sql = "UPDATE Estudiantes SET nom_e = ?, dir_e = ?, tel_e = ?, fech_nac = ?, id_carr = ? WHERE cod_e = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            bindEstudiante(ps, estudiante);
            ps.setInt(6, estudiante.getCodE());
            ps.executeUpdate();
        }
    }

    public void eliminar(int codE) throws SQLException {
        String sql = "DELETE FROM Estudiantes WHERE cod_e = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codE);
            ps.executeUpdate();
        }
    }

    private void bindEstudiante(PreparedStatement ps, Estudiante estudiante) throws SQLException {
        ps.setString(1, estudiante.getNomE());
        ps.setString(2, estudiante.getDirE());
        ps.setString(3, estudiante.getTelE());
        if (estudiante.getFechNac() != null) {
            ps.setDate(4, new Date(estudiante.getFechNac().getTime()));
        } else {
            ps.setNull(4, java.sql.Types.DATE);
        }
        if (estudiante.getCarrera() != null && estudiante.getCarrera().getIdCarr() > 0) {
            ps.setInt(5, estudiante.getCarrera().getIdCarr());
        } else {
            ps.setNull(5, java.sql.Types.INTEGER);
        }
    }

    private Estudiante mapear(ResultSet rs) throws SQLException {
        Estudiante e = new Estudiante();
        e.setCodE(rs.getInt("cod_e"));
        e.setNomE(rs.getString("nom_e"));
        e.setDirE(rs.getString("dir_e"));
        e.setTelE(rs.getString("tel_e"));
        Date fecha = rs.getDate("fech_nac");
        if (fecha != null) {
            e.setFechNac(new java.util.Date(fecha.getTime()));
        }
        int idCarr = rs.getInt("id_carr");
        if (!rs.wasNull()) {
            Carrera c = new Carrera();
            c.setIdCarr(idCarr);
            c.setNomCarr(rs.getString("nom_carr"));
            e.setCarrera(c);
        }
        return e;
    }
}
