package com.mycompany.gestion.academica.dao;

import com.mycompany.gestion.academica.modelo.Asignatura;
import com.mycompany.gestion.academica.modelo.CursoImpartido;
import com.mycompany.gestion.academica.modelo.Profesor;
import com.mycompany.gestion.academica.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImparteDAO {

    public List<CursoImpartido> listar() throws SQLException {
        List<CursoImpartido> lista = new ArrayList<>();
        String sql = """
            SELECT i.id_p, i.cod_a, i.grupo, i.horario,
                   p.nom_p, a.nom_a
            FROM Imparte i
            JOIN Profesores p ON i.id_p = p.id_p
            JOIN Asignaturas a ON i.cod_a = a.cod_a
            ORDER BY i.cod_a, i.grupo
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

    public List<CursoImpartido> listarPorProfesor(int idP) throws SQLException {
        List<CursoImpartido> lista = new ArrayList<>();
        String sql = """
            SELECT i.id_p, i.cod_a, i.grupo, i.horario,
                   p.nom_p, a.nom_a
            FROM Imparte i
            JOIN Profesores p ON i.id_p = p.id_p
            JOIN Asignaturas a ON i.cod_a = a.cod_a
            WHERE i.id_p = ?
            ORDER BY a.nom_a, i.grupo
            """;
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idP);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }
        }
        return lista;
    }

    public List<CursoImpartido> listarPorAsignatura(int codA) throws SQLException {
        List<CursoImpartido> lista = new ArrayList<>();
        String sql = """
            SELECT i.id_p, i.cod_a, i.grupo, i.horario,
                   p.nom_p, a.nom_a
            FROM Imparte i
            JOIN Profesores p ON i.id_p = p.id_p
            JOIN Asignaturas a ON i.cod_a = a.cod_a
            WHERE i.cod_a = ?
            ORDER BY p.nom_p, i.grupo
            """;
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codA);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }
        }
        return lista;
    }

    public CursoImpartido buscar(int idP, int codA, String grupo) throws SQLException {
        String sql = """
            SELECT i.id_p, i.cod_a, i.grupo, i.horario,
                   p.nom_p, a.nom_a
            FROM Imparte i
            JOIN Profesores p ON i.id_p = p.id_p
            JOIN Asignaturas a ON i.cod_a = a.cod_a
            WHERE i.id_p = ? AND i.cod_a = ? AND i.grupo = ?
            """;
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idP);
            ps.setInt(2, codA);
            ps.setString(3, grupo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }
        }
        return null;
    }

    public void insertar(CursoImpartido curso) throws SQLException {
        String sql = "INSERT INTO Imparte (id_p, cod_a, grupo, horario) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, curso.getProfesor().getIdP());
            ps.setInt(2, curso.getAsignatura().getCodA());
            ps.setString(3, curso.getGrupo());
            ps.setString(4, curso.getHorario());
            ps.executeUpdate();
        }
    }

    public void actualizar(CursoImpartido curso, int idPAnterior, int codAAnterior, String grupoAnterior) throws SQLException {
        String sql = "UPDATE Imparte SET id_p = ?, cod_a = ?, grupo = ?, horario = ? WHERE id_p = ? AND cod_a = ? AND grupo = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, curso.getProfesor().getIdP());
            ps.setInt(2, curso.getAsignatura().getCodA());
            ps.setString(3, curso.getGrupo());
            ps.setString(4, curso.getHorario());
            ps.setInt(5, idPAnterior);
            ps.setInt(6, codAAnterior);
            ps.setString(7, grupoAnterior);
            ps.executeUpdate();
        }
    }

    public void eliminar(int idP, int codA, String grupo) throws SQLException {
        String sql = "DELETE FROM Imparte WHERE id_p = ? AND cod_a = ? AND grupo = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idP);
            ps.setInt(2, codA);
            ps.setString(3, grupo);
            ps.executeUpdate();
        }
    }

    private CursoImpartido mapear(ResultSet rs) throws SQLException {
        Profesor p = new Profesor();
        p.setIdP(rs.getInt("id_p"));
        p.setNomP(rs.getString("nom_p"));
        Asignatura a = new Asignatura();
        a.setCodA(rs.getInt("cod_a"));
        a.setNomA(rs.getString("nom_a"));
        CursoImpartido c = new CursoImpartido(p, a, rs.getString("grupo"), rs.getString("horario"));
        return c;
    }
}
