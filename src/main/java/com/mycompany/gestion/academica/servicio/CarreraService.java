package com.mycompany.gestion.academica.servicio;

import com.mycompany.gestion.academica.dao.CarreraDAO;
import com.mycompany.gestion.academica.modelo.Carrera;
import java.sql.SQLException;
import java.util.List;

public class CarreraService {

    private final CarreraDAO carreraDAO = new CarreraDAO();

    public List<Carrera> listar() throws SQLException {
        return carreraDAO.listar();
    }

    public Carrera buscarPorId(int id) throws SQLException {
        return carreraDAO.buscarPorId(id);
    }

    public int guardar(Carrera carrera) throws SQLException {
        validar(carrera);
        if (carrera.getIdCarr() > 0) {
            carreraDAO.actualizar(carrera);
            return carrera.getIdCarr();
        }
        int id = carreraDAO.insertar(carrera);
        carrera.setIdCarr(id);
        return id;
    }

    public void eliminar(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("Seleccione una carrera para eliminar.");
        }
        carreraDAO.eliminar(id);
    }

    private void validar(Carrera carrera) {
        if (carrera.getNomCarr() == null || carrera.getNomCarr().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la carrera es obligatorio.");
        }
    }
}
