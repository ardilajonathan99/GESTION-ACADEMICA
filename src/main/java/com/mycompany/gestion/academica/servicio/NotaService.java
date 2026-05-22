package com.mycompany.gestion.academica.servicio;

import com.mycompany.gestion.academica.dao.InscribeDAO;
import com.mycompany.gestion.academica.dao.InscribeDAO.InscripcionDetalle;
import com.mycompany.gestion.academica.modelo.Inscripcion;
import com.mycompany.gestion.academica.util.Sesion;
import java.sql.SQLException;
import java.util.List;

/**
 * Calificación: el profesor registra notas sobre inscripciones existentes; el administrador puede calificar cualquier curso.
 */
public class NotaService {

    private static final double PESO_N1 = 0.35;
    private static final double PESO_N2 = 0.35;
    private static final double PESO_N3 = 0.30;

    private final InscribeDAO inscribeDAO = new InscribeDAO();

    public List<InscripcionDetalle> listarParaRegistro() throws SQLException {
        if (Sesion.esProfesor()) {
            return inscribeDAO.listarPorProfesor(Sesion.getIdUsuario());
        }
        return inscribeDAO.listarDetalle();
    }

    public List<InscripcionDetalle> listarPorEstudiante(int codE) throws SQLException {
        return inscribeDAO.listarPorEstudiante(codE);
    }

    public void registrarNotas(int codE, int codA, int idP, String grupo, double n1, double n2, double n3) throws SQLException {
        validarPermisoNotas(idP);
        validarNota(n1);
        validarNota(n2);
        validarNota(n3);
        inscribeDAO.actualizarNotas(codE, codA, idP, grupo, n1, n2, n3);
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

    private void validarPermisoNotas(int idProfesorCurso) {
        if (!Sesion.esAdmin() && !Sesion.esProfesor()) {
            throw new IllegalArgumentException("No tiene permiso para registrar notas.");
        }
        if (Sesion.esProfesor() && Sesion.getIdUsuario() != idProfesorCurso) {
            throw new IllegalArgumentException("Solo puede calificar cursos que usted imparte.");
        }
    }

    private void validarNota(double nota) {
        if (nota < 0 || nota > 5) {
            throw new IllegalArgumentException("Las notas deben estar entre 0.0 y 5.0");
        }
    }
}
