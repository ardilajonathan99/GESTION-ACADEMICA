package com.mycompany.gestion.academica.controlador;

import com.mycompany.gestion.academica.modelo.Asignatura;
import com.mycompany.gestion.academica.servicio.AsignaturaService;
import java.sql.SQLException;
import java.util.List;

public class AsignaturaController {

    private final AsignaturaService asignaturaService = new AsignaturaService();

    public List<Asignatura> listar() throws SQLException {
        return asignaturaService.listar();
    }

    public void guardar(Asignatura asignatura) throws SQLException {
        asignaturaService.guardar(asignatura);
    }

    public void eliminar(int codA) throws SQLException {
        asignaturaService.eliminar(codA);
    }
}
