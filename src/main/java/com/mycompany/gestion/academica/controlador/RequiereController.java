package com.mycompany.gestion.academica.controlador;

import com.mycompany.gestion.academica.dao.RequiereDAO.RequiereDetalle;
import com.mycompany.gestion.academica.servicio.RequiereService;
import java.sql.SQLException;
import java.util.List;

public class RequiereController {

    private final RequiereService requiereService = new RequiereService();

    public List<RequiereDetalle> listar() throws SQLException {
        return requiereService.listar();
    }

    public void registrar(int codA, int codAR) throws SQLException {
        requiereService.registrar(codA, codAR);
    }

    public void eliminar(int codA, int codAR) throws SQLException {
        requiereService.eliminar(codA, codAR);
    }
}
