package com.mycompany.gestion.academica.servicio;

import com.mycompany.gestion.academica.dao.EstudianteDAO;
import com.mycompany.gestion.academica.dao.ProfesorDAO;
import com.mycompany.gestion.academica.modelo.Estudiante;
import com.mycompany.gestion.academica.modelo.Profesor;
import com.mycompany.gestion.academica.modelo.TipoUsuario;
import com.mycompany.gestion.academica.util.Sesion;
import java.sql.SQLException;

public class AutenticacionService {

    public static final String ADMIN_USUARIO = "admin";
    public static final String CLAVE_DEFECTO = "1234";

    private final EstudianteDAO estudianteDAO = new EstudianteDAO();
    private final ProfesorDAO profesorDAO = new ProfesorDAO();

    public void autenticar(TipoUsuario tipo, String usuario, String clave) throws SQLException {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new IllegalArgumentException("Ingrese el usuario.");
        }
        if (clave == null || clave.isEmpty()) {
            throw new IllegalArgumentException("Ingrese la contraseña.");
        }

        switch (tipo) {
            case ADMIN -> autenticarAdmin(usuario.trim(), clave);
            case ESTUDIANTE -> autenticarEstudiante(usuario.trim(), clave);
            case PROFESOR -> autenticarProfesor(usuario.trim(), clave);
            default -> throw new IllegalArgumentException("Seleccione un tipo de usuario válido.");
        }
    }

    private void autenticarAdmin(String usuario, String clave) {
        if (!ADMIN_USUARIO.equalsIgnoreCase(usuario)) {
            throw new IllegalArgumentException("Usuario administrador no válido.");
        }
        if (!CLAVE_DEFECTO.equals(clave)) {
            throw new IllegalArgumentException("Contraseña incorrecta.");
        }
        Sesion.iniciar(TipoUsuario.ADMIN, 0, "Administrador");
    }

    private void autenticarEstudiante(String usuario, String clave) throws SQLException {
        validarClave(clave);
        int codE = parsearCodigo(usuario, "código de estudiante");
        Estudiante estudiante = estudianteDAO.buscarPorId(codE);
        if (estudiante == null) {
            throw new IllegalArgumentException("No existe un estudiante con el código " + codE + ".");
        }
        Sesion.iniciar(TipoUsuario.ESTUDIANTE, estudiante.getCodE(), estudiante.getNomE());
    }

    private void autenticarProfesor(String usuario, String clave) throws SQLException {
        validarClave(clave);
        int idP = parsearCodigo(usuario, "ID de profesor");
        Profesor profesor = profesorDAO.buscarPorId(idP);
        if (profesor == null) {
            throw new IllegalArgumentException("No existe un profesor con el ID " + idP + ".");
        }
        Sesion.iniciar(TipoUsuario.PROFESOR, profesor.getIdP(), profesor.getNomP());
    }

    private void validarClave(String clave) {
        if (!CLAVE_DEFECTO.equals(clave)) {
            throw new IllegalArgumentException("Contraseña incorrecta.");
        }
    }

    private int parsearCodigo(String usuario, String etiqueta) {
        try {
            int codigo = Integer.parseInt(usuario);
            if (codigo <= 0) {
                throw new NumberFormatException();
            }
            return codigo;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Ingrese un " + etiqueta + " numérico válido.");
        }
    }
}
