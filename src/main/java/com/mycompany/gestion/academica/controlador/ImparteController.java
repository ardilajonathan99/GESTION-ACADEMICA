package com.mycompany.gestion.academica.controlador;

import com.mycompany.gestion.academica.modelo.CursoImpartido;
import com.mycompany.gestion.academica.servicio.ImparteService;
import java.sql.SQLException;
import java.util.List;

public class ImparteController {

    private final ImparteService imparteService = new ImparteService();

    public List<CursoImpartido> listar() throws SQLException {
        return imparteService.listar();
    }

    public List<CursoImpartido> listarPorAsignatura(int codA) throws SQLException {
        return imparteService.listarPorAsignatura(codA);
    }

    public void guardar(CursoImpartido curso) throws SQLException {
        imparteService.guardar(curso);
    }

    public void actualizar(CursoImpartido curso, int idPAnterior, int codAAnterior, String grupoAnterior) throws SQLException {
        imparteService.actualizar(curso, idPAnterior, codAAnterior, grupoAnterior);
    }

    public void eliminar(int idP, int codA, String grupo) throws SQLException {
        imparteService.eliminar(idP, codA, grupo);
    }
}
