package com.mycompany.gestion.academica.dao;

import com.mycompany.gestion.academica.modelo.Asignatura;
import com.mycompany.gestion.academica.modelo.CursoImpartido;
import com.mycompany.gestion.academica.modelo.Estudiante;
import com.mycompany.gestion.academica.modelo.Inscripcion;
import com.mycompany.gestion.academica.modelo.Profesor;
import com.mycompany.gestion.academica.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InscribeDAO {

    public static class InscripcionDetalle {

        private int codE;
        private int codA;
        private int idP;
        private String grupo;
        private String nomEstudiante;
        private String nomAsignatura;
        private String nomProfesor;
        private String horario;
        private Double n1;
        private Double n2;
        private Double n3;
        private Double definitiva;

        public int getCodE() { return codE; }
        public int getCodA() { return codA; }
        public int getIdP() { return idP; }
        public String getGrupo() { return grupo; }
        public String getNomEstudiante() { return nomEstudiante; }
        public String getNomAsignatura() { return nomAsignatura; }
        public String getNomProfesor() { return nomProfesor; }
        public String getHorario() { return horario; }
        public Double getN1() { return n1; }
        public Double getN2() { return n2; }
        public Double getN3() { return n3; }
        public Double getDefinitiva() { return definitiva; }

        public String etiquetaCurso() {
            return nomAsignatura + " - " + nomProfesor + " (Grupo " + grupo + ")";
        }
    }

    public List<InscripcionDetalle> listarDetalle() throws SQLException {
        List<InscripcionDetalle> lista = new ArrayList<>();
        String sql = """
            SELECT i.cod_e, i.cod_a, i.id_p, i.grupo,
                   e.nom_e, a.nom_a, p.nom_p, imp.horario,
                   i.n1, i.n2, i.n3,
                   (i.n1 * 0.35 + i.n2 * 0.35 + i.n3 * 0.30) AS definitiva
            FROM Inscribe i
            JOIN Estudiantes e ON i.cod_e = e.cod_e
            JOIN Asignaturas a ON i.cod_a = a.cod_a
            JOIN Profesores p ON i.id_p = p.id_p
            JOIN Imparte imp ON i.id_p = imp.id_p AND i.cod_a = imp.cod_a AND i.grupo = imp.grupo
            ORDER BY e.nom_e, a.nom_a
            """;
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapearDetalle(rs));
            }
        }
        return lista;
    }

    public List<InscripcionDetalle> listarPorProfesor(int idP) throws SQLException {
        List<InscripcionDetalle> lista = new ArrayList<>();
        String sql = """
            SELECT i.cod_e, i.cod_a, i.id_p, i.grupo,
                   e.nom_e, a.nom_a, p.nom_p, imp.horario,
                   i.n1, i.n2, i.n3,
                   (i.n1 * 0.35 + i.n2 * 0.35 + i.n3 * 0.30) AS definitiva
            FROM Inscribe i
            JOIN Estudiantes e ON i.cod_e = e.cod_e
            JOIN Asignaturas a ON i.cod_a = a.cod_a
            JOIN Profesores p ON i.id_p = p.id_p
            JOIN Imparte imp ON i.id_p = imp.id_p AND i.cod_a = imp.cod_a AND i.grupo = imp.grupo
            WHERE i.id_p = ?
            ORDER BY e.nom_e, a.nom_a
            """;
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idP);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearDetalle(rs));
                }
            }
        }
        return lista;
    }

    public List<InscripcionDetalle> listarPorEstudiante(int codE) throws SQLException {
        List<InscripcionDetalle> lista = new ArrayList<>();
        String sql = """
            SELECT i.cod_e, i.cod_a, i.id_p, i.grupo,
                   e.nom_e, a.nom_a, p.nom_p, imp.horario,
                   i.n1, i.n2, i.n3,
                   (i.n1 * 0.35 + i.n2 * 0.35 + i.n3 * 0.30) AS definitiva
            FROM Inscribe i
            JOIN Estudiantes e ON i.cod_e = e.cod_e
            JOIN Asignaturas a ON i.cod_a = a.cod_a
            JOIN Profesores p ON i.id_p = p.id_p
            JOIN Imparte imp ON i.id_p = imp.id_p AND i.cod_a = imp.cod_a AND i.grupo = imp.grupo
            WHERE i.cod_e = ?
            ORDER BY a.nom_a
            """;
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codE);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearDetalle(rs));
                }
            }
        }
        return lista;
    }

    public InscripcionDetalle buscar(int codE, int codA, int idP, String grupo) throws SQLException {
        String sql = """
            SELECT i.cod_e, i.cod_a, i.id_p, i.grupo,
                   e.nom_e, a.nom_a, p.nom_p, imp.horario,
                   i.n1, i.n2, i.n3,
                   (i.n1 * 0.35 + i.n2 * 0.35 + i.n3 * 0.30) AS definitiva
            FROM Inscribe i
            JOIN Estudiantes e ON i.cod_e = e.cod_e
            JOIN Asignaturas a ON i.cod_a = a.cod_a
            JOIN Profesores p ON i.id_p = p.id_p
            JOIN Imparte imp ON i.id_p = imp.id_p AND i.cod_a = imp.cod_a AND i.grupo = imp.grupo
            WHERE i.cod_e = ? AND i.cod_a = ? AND i.id_p = ? AND i.grupo = ?
            """;
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codE);
            ps.setInt(2, codA);
            ps.setInt(3, idP);
            ps.setString(4, grupo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearDetalle(rs);
                }
            }
        }
        return null;
    }

    public void insertar(Inscripcion inscripcion) throws SQLException {
        String sql = "INSERT INTO Inscribe (cod_e, cod_a, id_p, grupo) VALUES (?, ?, ?, ?)";
        CursoImpartido curso = inscripcion.getCurso();
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, inscripcion.getEstudiante().getCodE());
            ps.setInt(2, curso.getAsignatura().getCodA());
            ps.setInt(3, curso.getProfesor().getIdP());
            ps.setString(4, curso.getGrupo());
            ps.executeUpdate();
        }
    }

    public void actualizarNotas(int codE, int codA, int idP, String grupo, double n1, double n2, double n3) throws SQLException {
        String sql = "UPDATE Inscribe SET n1 = ?, n2 = ?, n3 = ? WHERE cod_e = ? AND cod_a = ? AND id_p = ? AND grupo = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, n1);
            ps.setDouble(2, n2);
            ps.setDouble(3, n3);
            ps.setInt(4, codE);
            ps.setInt(5, codA);
            ps.setInt(6, idP);
            ps.setString(7, grupo);
            ps.executeUpdate();
        }
    }

    public void eliminar(int codE, int codA, int idP, String grupo) throws SQLException {
        String sql = "DELETE FROM Inscribe WHERE cod_e = ? AND cod_a = ? AND id_p = ? AND grupo = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codE);
            ps.setInt(2, codA);
            ps.setInt(3, idP);
            ps.setString(4, grupo);
            ps.executeUpdate();
        }
    }

    public Inscripcion mapearInscripcion(InscripcionDetalle d) {
        Estudiante e = new Estudiante();
        e.setCodE(d.getCodE());
        e.setNomE(d.getNomEstudiante());
        Profesor p = new Profesor();
        p.setIdP(d.getIdP());
        p.setNomP(d.getNomProfesor());
        Asignatura a = new Asignatura();
        a.setCodA(d.getCodA());
        a.setNomA(d.getNomAsignatura());
        CursoImpartido curso = new CursoImpartido(p, a, d.getGrupo(), d.getHorario());
        Inscripcion ins = new Inscripcion(e, curso);
        if (d.getN1() != null) ins.setN1(d.getN1());
        if (d.getN2() != null) ins.setN2(d.getN2());
        if (d.getN3() != null) ins.setN3(d.getN3());
        return ins;
    }

    private InscripcionDetalle mapearDetalle(ResultSet rs) throws SQLException {
        InscripcionDetalle d = new InscripcionDetalle();
        d.codE = rs.getInt("cod_e");
        d.codA = rs.getInt("cod_a");
        d.idP = rs.getInt("id_p");
        d.grupo = rs.getString("grupo");
        d.nomEstudiante = rs.getString("nom_e");
        d.nomAsignatura = rs.getString("nom_a");
        d.nomProfesor = rs.getString("nom_p");
        d.horario = rs.getString("horario");
        double n1 = rs.getDouble("n1");
        if (!rs.wasNull()) d.n1 = n1;
        double n2 = rs.getDouble("n2");
        if (!rs.wasNull()) d.n2 = n2;
        double n3 = rs.getDouble("n3");
        if (!rs.wasNull()) d.n3 = n3;
        double def = rs.getDouble("definitiva");
        if (!rs.wasNull()) d.definitiva = def;
        return d;
    }
}
