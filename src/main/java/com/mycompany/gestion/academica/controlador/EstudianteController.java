package com.mycompany.gestion.academica.controlador;

import com.mycompany.gestion.academica.modelo.Estudiante;
import com.mycompany.gestion.academica.servicio.EstudianteService;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class EstudianteController {

    private final EstudianteService estudianteService = new EstudianteService();

    public List<Estudiante> listar() throws SQLException {
        return estudianteService.listar();
    }

    public void guardar(Estudiante estudiante) throws SQLException {
        estudianteService.guardar(estudiante);
    }

    public void eliminar(int codE) throws SQLException {
        estudianteService.eliminar(codE);
    }

    public Date parseFecha(String texto) {
        return estudianteService.parseFecha(texto);
    }
}
