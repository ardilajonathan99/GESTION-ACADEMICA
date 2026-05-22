package com.mycompany.gestion.academica.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Conexión JDBC a PostgreSQL.
 * <p>
 * Configure la base desde variables de entorno (consola o NetBeans):
 * <ul>
 *   <li>{@code DB_HOST} — por defecto {@code localhost}</li>
 *   <li>{@code DB_PORT} — por defecto {@code 5432}</li>
 *   <li>{@code DB_NAME} — por defecto {@code postgres}</li>
 *   <li>{@code DB_USER} — por defecto {@code postgres}</li>
 *   <li>{@code DB_PASSWORD} — obligatoria</li>
 * </ul>
 * Ejemplo local (PowerShell): {@code $env:DB_PASSWORD='tu_clave'; mvn exec:java -Dexec.mainClass=...}
 */
public final class ConexionBD {

    private static final String HOST = "gestion-academica.cm7o0yekoeve.us-east-1.rds.amazonaws.com";
    private static final String PORT = "5432";
    private static final String DATABASE = "postgres"; // Cambiar por 'gestion-academica' si creaste un contenedor específico
    private static final String USER = "postgres";
    private static final String PASSWORD = "Informatica2026"; // Coloca aquí la contraseña real

    private ConexionBD() {
    }

    public static Connection conectar() throws SQLException {
        if (PASSWORD == null || PASSWORD.isBlank()) {
            throw new SQLException(
                    "Falta la variable de entorno DB_PASSWORD. "
                    + "En PowerShell: $env:DB_PASSWORD='tu_contraseña'");
        }
        String url = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;
        return DriverManager.getConnection(url, USER, PASSWORD);
    }

    public static String resumenConexion() {
        return USER + "@" + HOST + ":" + PORT + "/" + DATABASE;
    }

    private static String config(String envKey, String valorPorDefecto) {
        String valor = System.getenv(envKey);
        if (valor != null && !valor.isBlank()) {
            return valor.trim();
        }
        return valorPorDefecto;
    }
}
