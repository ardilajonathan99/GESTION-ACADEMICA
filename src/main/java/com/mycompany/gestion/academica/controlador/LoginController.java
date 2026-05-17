package com.mycompany.gestion.academica.controlador;

import com.mycompany.gestion.academica.modelo.TipoUsuario;
import com.mycompany.gestion.academica.servicio.AutenticacionService;
import java.sql.SQLException;

public class LoginController {

    private final AutenticacionService autenticacionService = new AutenticacionService();

    public void ingresar(TipoUsuario tipo, String usuario, String clave) throws SQLException {
        autenticacionService.autenticar(tipo, usuario, clave);
    }

    public static TipoUsuario parsearTipo(String texto) {
        if (texto == null || texto.startsWith("--")) {
            throw new IllegalArgumentException("Seleccione el tipo de usuario.");
        }
        return switch (texto) {
            case "Administrador" -> TipoUsuario.ADMIN;
            case "Estudiante" -> TipoUsuario.ESTUDIANTE;
            case "Profesor" -> TipoUsuario.PROFESOR;
            default -> throw new IllegalArgumentException("Tipo de usuario no válido.");
        };
    }
}
