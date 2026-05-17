package com.mycompany.gestion.academica.util;

import com.mycompany.gestion.academica.modelo.TipoUsuario;

/**
 * Usuario autenticado en la aplicación (una sesión por ejecución).
 */
public final class Sesion {

    private static TipoUsuario tipo;
    private static int idUsuario;
    private static String nombre;

    private Sesion() {
    }

    public static void iniciar(TipoUsuario tipoUsuario, int id, String nombreUsuario) {
        tipo = tipoUsuario;
        idUsuario = id;
        nombre = nombreUsuario;
    }

    public static void cerrar() {
        tipo = null;
        idUsuario = 0;
        nombre = null;
    }

    public static boolean haySesion() {
        return tipo != null;
    }

    public static TipoUsuario getTipo() {
        return tipo;
    }

    public static int getIdUsuario() {
        return idUsuario;
    }

    public static String getNombre() {
        return nombre;
    }

    public static boolean esAdmin() {
        return tipo == TipoUsuario.ADMIN;
    }

    public static boolean esEstudiante() {
        return tipo == TipoUsuario.ESTUDIANTE;
    }

    public static boolean esProfesor() {
        return tipo == TipoUsuario.PROFESOR;
    }
}
