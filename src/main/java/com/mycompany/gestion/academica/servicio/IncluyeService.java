package com.mycompany.gestion.academica.servicio;

import com.mycompany.gestion.academica.dao.IncluyeDAO;
import com.mycompany.gestion.academica.dao.IncluyeDAO.IncluyeDetalle;
import java.sql.SQLException;
import java.util.List;

public class IncluyeService {

    private final IncluyeDAO incluyeDAO = new IncluyeDAO();

    public List<IncluyeDetalle> listar() throws SQLException {
        return incluyeDAO.listar();
    }

    public void asociar(int idCarr, int codA) throws SQLException {
        if (idCarr <= 0 || codA <= 0) {
            throw new IllegalArgumentException("Seleccione carrera y asignatura.");
        }
        incluyeDAO.insertar(idCarr, codA);
    }

    public void eliminar(int idCarr, int codA) throws SQLException {
        if (idCarr <= 0 || codA <= 0) {
            throw new IllegalArgumentException("Seleccione una asociación de la tabla.");
        }
        incluyeDAO.eliminar(idCarr, codA);
    }
}
