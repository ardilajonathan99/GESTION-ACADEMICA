package com.mycompany.gestion.academica.controlador;

import com.mycompany.gestion.academica.dao.InscribeDAO.InscripcionDetalle;
import com.mycompany.gestion.academica.modelo.Inscripcion;
import com.mycompany.gestion.academica.servicio.InscripcionService;
import java.sql.SQLException;
import java.util.List;

public class InscripcionController {

    private final InscripcionService inscripcionService = new InscripcionService();

    public List<InscripcionDetalle> listarDetalle() throws SQLException {
        return inscripcionService.listarDetalle();
    }

    public List<InscripcionDetalle> listarPorEstudiante(int codE) throws SQLException {
        return inscripcionService.listarPorEstudiante(codE);
    }

    public List<InscripcionDetalle> listarMisNotas() throws SQLException {
        return inscripcionService.listarMisNotas();
    }

    public void inscribir(Inscripcion inscripcion) throws SQLException {
        inscripcionService.inscribir(inscripcion);
    }

    public void eliminar(int codE, int codA, int idP, String grupo) throws SQLException {
        inscripcionService.eliminar(codE, codA, idP, grupo);
    }
}
