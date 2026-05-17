package com.mycompany.gestion.academica.controlador;

import com.mycompany.gestion.academica.modelo.Profesor;
import com.mycompany.gestion.academica.servicio.ProfesorService;
import java.sql.SQLException;
import java.util.List;

public class ProfesorController {

    private final ProfesorService profesorService = new ProfesorService();

    public List<Profesor> listar() throws SQLException {
        return profesorService.listar();
    }

    public void guardar(Profesor profesor) throws SQLException {
        profesorService.guardar(profesor);
    }

    public void eliminar(int idP) throws SQLException {
        profesorService.eliminar(idP);
    }
}
