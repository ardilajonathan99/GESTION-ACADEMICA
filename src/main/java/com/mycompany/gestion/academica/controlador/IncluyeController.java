package com.mycompany.gestion.academica.controlador;

import com.mycompany.gestion.academica.dao.IncluyeDAO.IncluyeDetalle;
import com.mycompany.gestion.academica.servicio.IncluyeService;
import java.sql.SQLException;
import java.util.List;

public class IncluyeController {

    private final IncluyeService incluyeService = new IncluyeService();

    public List<IncluyeDetalle> listar() throws SQLException {
        return incluyeService.listar();
    }

    public void asociar(int idCarr, int codA) throws SQLException {
        incluyeService.asociar(idCarr, codA);
    }

    public void eliminar(int idCarr, int codA) throws SQLException {
        incluyeService.eliminar(idCarr, codA);
    }
}
