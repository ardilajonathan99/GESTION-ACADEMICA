package com.mycompany.gestion.academica.controlador;

import com.mycompany.gestion.academica.dao.InscribeDAO.InscripcionDetalle;
import com.mycompany.gestion.academica.servicio.NotaService;
import java.sql.SQLException;
import java.util.List;

public class NotaController {

    private final NotaService notaService = new NotaService();

    public List<InscripcionDetalle> listarParaRegistro() throws SQLException {
        return notaService.listarParaRegistro();
    }

    public List<InscripcionDetalle> listarPorEstudiante(int codE) throws SQLException {
        return notaService.listarPorEstudiante(codE);
    }

    public void registrarNotas(int codE, int codA, int idP, String grupo, double n1, double n2, double n3) throws SQLException {
        notaService.registrarNotas(codE, codA, idP, grupo, n1, n2, n3);
    }

    public double calcularDefinitiva(double n1, double n2, double n3) {
        return notaService.calcularDefinitiva(n1, n2, n3);
    }
}
