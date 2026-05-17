package com.mycompany.gestion.academica.controlador;

import com.mycompany.gestion.academica.modelo.Carrera;
import com.mycompany.gestion.academica.servicio.CarreraService;
import java.sql.SQLException;
import java.util.List;

public class CarreraController {

    private final CarreraService carreraService = new CarreraService();

    public List<Carrera> listar() throws SQLException {
        return carreraService.listar();
    }

    public void guardar(Carrera carrera) throws SQLException {
        carreraService.guardar(carrera);
    }

    public void eliminar(int id) throws SQLException {
        carreraService.eliminar(id);
    }
}
