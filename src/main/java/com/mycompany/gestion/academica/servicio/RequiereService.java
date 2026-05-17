package com.mycompany.gestion.academica.servicio;

import com.mycompany.gestion.academica.dao.RequiereDAO;
import com.mycompany.gestion.academica.dao.RequiereDAO.RequiereDetalle;
import java.sql.SQLException;
import java.util.List;

public class RequiereService {

    private final RequiereDAO requiereDAO = new RequiereDAO();

    public List<RequiereDetalle> listar() throws SQLException {
        return requiereDAO.listar();
    }

    public void registrar(int codA, int codAR) throws SQLException {
        if (codA <= 0 || codAR <= 0) {
            throw new IllegalArgumentException("Seleccione asignatura y prerrequisito.");
        }
        if (codA == codAR) {
            throw new IllegalArgumentException("La asignatura no puede ser prerrequisito de sí misma.");
        }
        requiereDAO.insertar(codA, codAR);
    }

    public void eliminar(int codA, int codAR) throws SQLException {
        if (codA <= 0 || codAR <= 0) {
            throw new IllegalArgumentException("Seleccione un requisito de la tabla.");
        }
        requiereDAO.eliminar(codA, codAR);
    }
}
