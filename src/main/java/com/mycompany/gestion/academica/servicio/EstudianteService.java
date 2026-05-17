package com.mycompany.gestion.academica.servicio;

import com.mycompany.gestion.academica.dao.EstudianteDAO;
import com.mycompany.gestion.academica.modelo.Estudiante;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class EstudianteService {

    private final EstudianteDAO estudianteDAO = new EstudianteDAO();
    private final SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

    public List<Estudiante> listar() throws SQLException {
        return estudianteDAO.listar();
    }

    public void guardar(Estudiante estudiante) throws SQLException {
        validar(estudiante);
        if (estudiante.getCodE() > 0) {
            estudianteDAO.actualizar(estudiante);
        } else {
            int id = estudianteDAO.insertar(estudiante);
            estudiante.setCodE(id);
        }
    }

    public void eliminar(int codE) throws SQLException {
        if (codE <= 0) {
            throw new IllegalArgumentException("Seleccione un estudiante para eliminar.");
        }
        estudianteDAO.eliminar(codE);
    }

    public java.util.Date parseFecha(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return null;
        }
        try {
            formatoFecha.setLenient(false);
            return formatoFecha.parse(texto.trim());
        } catch (ParseException ex) {
            throw new IllegalArgumentException("Fecha inválida. Use el formato AAAA-MM-DD.");
        }
    }

    private void validar(Estudiante estudiante) {
        if (estudiante.getNomE() == null || estudiante.getNomE().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del estudiante es obligatorio.");
        }
    }
}
