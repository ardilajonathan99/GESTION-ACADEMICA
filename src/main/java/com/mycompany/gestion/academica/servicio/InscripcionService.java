package com.mycompany.gestion.academica.servicio;

import com.mycompany.gestion.academica.dao.InscribeDAO;
import com.mycompany.gestion.academica.dao.InscribeDAO.InscripcionDetalle;
import com.mycompany.gestion.academica.modelo.Inscripcion;
import com.mycompany.gestion.academica.util.Sesion;
import java.sql.SQLException;
import java.util.List;

/**
 * Matrícula: el estudiante inscribe cursos; el administrador puede gestionar cualquier inscripción.
 */
public class InscripcionService {

    private final InscribeDAO inscribeDAO = new InscribeDAO();

    public List<InscripcionDetalle> listarDetalle() throws SQLException {
        if (Sesion.esEstudiante()) {
            return inscribeDAO.listarPorEstudiante(Sesion.getIdUsuario());
        }
        return inscribeDAO.listarDetalle();
    }

    public List<InscripcionDetalle> listarPorEstudiante(int codE) throws SQLException {
        validarPermisoMatricula(codE);
        return inscribeDAO.listarPorEstudiante(codE);
    }

    /** Consulta de notas del estudiante autenticado. */
    public List<InscripcionDetalle> listarMisNotas() throws SQLException {
        if (!Sesion.esEstudiante()) {
            throw new IllegalArgumentException("Solo el estudiante puede consultar sus notas.");
        }
        return inscribeDAO.listarPorEstudiante(Sesion.getIdUsuario());
    }

    public void inscribir(Inscripcion inscripcion) throws SQLException {
        if (inscripcion.getEstudiante() == null || inscripcion.getEstudiante().getCodE() <= 0) {
            throw new IllegalArgumentException("Seleccione un estudiante.");
        }
        if (inscripcion.getCurso() == null || inscripcion.getCurso().getAsignatura() == null
                || inscripcion.getCurso().getProfesor() == null) {
            throw new IllegalArgumentException("Seleccione un curso válido.");
        }
        validarPermisoMatricula(inscripcion.getEstudiante().getCodE());
        inscribeDAO.insertar(inscripcion);
    }

    public void eliminar(int codE, int codA, int idP, String grupo) throws SQLException {
        validarPermisoMatricula(codE);
        inscribeDAO.eliminar(codE, codA, idP, grupo);
    }

    private void validarPermisoMatricula(int codEstudiante) {
        if (!Sesion.esAdmin() && !Sesion.esEstudiante()) {
            throw new IllegalArgumentException("No tiene permiso para gestionar inscripciones.");
        }
        if (Sesion.esEstudiante() && Sesion.getIdUsuario() != codEstudiante) {
            throw new IllegalArgumentException("Solo puede inscribir o dar de baja sus propios cursos.");
        }
    }
}
