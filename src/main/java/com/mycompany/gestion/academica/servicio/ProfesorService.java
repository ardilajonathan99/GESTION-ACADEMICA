package com.mycompany.gestion.academica.servicio;

import com.mycompany.gestion.academica.dao.ProfesorDAO;
import com.mycompany.gestion.academica.modelo.Profesor;
import java.sql.SQLException;
import java.util.List;

public class ProfesorService {

    private final ProfesorDAO profesorDAO = new ProfesorDAO();

    public List<Profesor> listar() throws SQLException {
        return profesorDAO.listar();
    }

    public void guardar(Profesor profesor) throws SQLException {
        if (profesor.getNomP() == null || profesor.getNomP().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del profesor es obligatorio.");
        }
        if (profesor.getIdP() > 0) {
            profesorDAO.actualizar(profesor);
        } else {
            int id = profesorDAO.insertar(profesor);
            profesor.setIdP(id);
        }
    }

    public void eliminar(int idP) throws SQLException {
        if (idP <= 0) {
            throw new IllegalArgumentException("Seleccione un profesor para eliminar.");
        }
        profesorDAO.eliminar(idP);
    }
}
