package com.mycompany.gestion.academica.servicio;

import com.mycompany.gestion.academica.dao.InscribeDAO;
import com.mycompany.gestion.academica.dao.InscribeDAO.InscripcionDetalle;
import com.mycompany.gestion.academica.modelo.Inscripcion;
import java.sql.SQLException;
import java.util.List;

public class InscripcionService {

    private static final double PESO_N1 = 0.35;
    private static final double PESO_N2 = 0.35;
    private static final double PESO_N3 = 0.30;

    private final InscribeDAO inscribeDAO = new InscribeDAO();

    public List<InscripcionDetalle> listarDetalle() throws SQLException {
        return inscribeDAO.listarDetalle();
    }

    public List<InscripcionDetalle> listarPorEstudiante(int codE) throws SQLException {
        return inscribeDAO.listarPorEstudiante(codE);
    }

    public void inscribir(Inscripcion inscripcion) throws SQLException {
        if (inscripcion.getEstudiante() == null || inscripcion.getEstudiante().getCodE() <= 0) {
            throw new IllegalArgumentException("Seleccione un estudiante.");
        }
        if (inscripcion.getCurso() == null || inscripcion.getCurso().getAsignatura() == null
                || inscripcion.getCurso().getProfesor() == null) {
            throw new IllegalArgumentException("Seleccione un curso válido.");
        }
        inscribeDAO.insertar(inscripcion);
    }

    public void guardarNotas(int codE, int codA, int idP, String grupo, double n1, double n2, double n3) throws SQLException {
        validarNota(n1);
        validarNota(n2);
        validarNota(n3);
        inscribeDAO.actualizarNotas(codE, codA, idP, grupo, n1, n2, n3);
    }

    public void eliminar(int codE, int codA, int idP, String grupo) throws SQLException {
        inscribeDAO.eliminar(codE, codA, idP, grupo);
    }

    public double calcularDefinitiva(double n1, double n2, double n3) {
        validarNota(n1);
        validarNota(n2);
        validarNota(n3);
        return (n1 * PESO_N1) + (n2 * PESO_N2) + (n3 * PESO_N3);
    }

    public double calcularDefinitiva(Inscripcion inscripcion) {
        return calcularDefinitiva(inscripcion.getN1(), inscripcion.getN2(), inscripcion.getN3());
    }

    private void validarNota(double nota) {
        if (nota < 0 || nota > 5) {
            throw new IllegalArgumentException("Las notas deben estar entre 0.0 y 5.0");
        }
    }
}
