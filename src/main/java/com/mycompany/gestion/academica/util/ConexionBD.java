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

    private static final String HOST = config("DB_HOST", "localhost");
    private static final String PORT = config("DB_PORT", "5432");
    private static final String DATABASE = config("DB_NAME", "postgres");
    private static final String USER = config("DB_USER", "postgres");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

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
