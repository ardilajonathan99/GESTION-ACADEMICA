package com.mycompany.gestion.academica.servicio;

import com.mycompany.gestion.academica.dao.ImparteDAO;
import com.mycompany.gestion.academica.modelo.CursoImpartido;
import com.mycompany.gestion.academica.util.Sesion;
import java.sql.SQLException;
import java.util.List;

public class ImparteService {

    private final ImparteDAO imparteDAO = new ImparteDAO();

    public List<CursoImpartido> listar() throws SQLException {
        if (Sesion.esProfesor()) {
            return imparteDAO.listarPorProfesor(Sesion.getIdUsuario());
        }
        return imparteDAO.listar();
    }

    public List<CursoImpartido> listarPorProfesor(int idP) throws SQLException {
        return imparteDAO.listarPorProfesor(idP);
    }

    public List<CursoImpartido> listarPorAsignatura(int codA) throws SQLException {
        return imparteDAO.listarPorAsignatura(codA);
    }

    public void guardar(CursoImpartido curso) throws SQLException {
        validarPermisoEscritura();
        validar(curso);
        imparteDAO.insertar(curso);
    }

    public void actualizar(CursoImpartido curso, int idPAnterior, int codAAnterior, String grupoAnterior) throws SQLException {
        validarPermisoEscritura();
        validar(curso);
        imparteDAO.actualizar(curso, idPAnterior, codAAnterior, grupoAnterior);
    }

    public void eliminar(int idP, int codA, String grupo) throws SQLException {
        validarPermisoEscritura();
        if (idP <= 0 || codA <= 0 || grupo == null || grupo.trim().isEmpty()) {
            throw new IllegalArgumentException("Seleccione un curso impartido de la tabla.");
        }
        imparteDAO.eliminar(idP, codA, grupo.trim());
    }

    private void validarPermisoEscritura() {
        if (Sesion.esProfesor()) {
            throw new IllegalArgumentException("Solo puede consultar sus cursos impartidos.");
        }
    }

    private void validar(CursoImpartido curso) {
        if (curso.getProfesor() == null || curso.getProfesor().getIdP() <= 0) {
            throw new IllegalArgumentException("Seleccione un profesor.");
        }
        if (curso.getAsignatura() == null || curso.getAsignatura().getCodA() <= 0) {
            throw new IllegalArgumentException("Seleccione una asignatura.");
        }
        if (curso.getGrupo() == null || curso.getGrupo().trim().isEmpty()) {
            throw new IllegalArgumentException("El grupo es obligatorio.");
        }
    }
}
