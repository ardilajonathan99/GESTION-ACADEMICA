package com.mycompany.gestion.academica.servicio;

import com.mycompany.gestion.academica.dao.AsignaturaDAO;
import com.mycompany.gestion.academica.modelo.Asignatura;
import java.sql.SQLException;
import java.util.List;

public class AsignaturaService {

    private final AsignaturaDAO asignaturaDAO = new AsignaturaDAO();

    public List<Asignatura> listar() throws SQLException {
        return asignaturaDAO.listar();
    }

    public void guardar(Asignatura asignatura) throws SQLException {
        if (asignatura.getNomA() == null || asignatura.getNomA().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la asignatura es obligatorio.");
        }
        if (asignatura.getCodA() > 0) {
            asignaturaDAO.actualizar(asignatura);
        } else {
            int id = asignaturaDAO.insertar(asignatura);
            asignatura.setCodA(id);
        }
    }

    public void eliminar(int codA) throws SQLException {
        if (codA <= 0) {
            throw new IllegalArgumentException("Seleccione una asignatura para eliminar.");
        }
        asignaturaDAO.eliminar(codA);
    }
}
