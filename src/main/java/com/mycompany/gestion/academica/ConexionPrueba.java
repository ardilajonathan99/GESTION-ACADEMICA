package com.mycompany.gestion.academica.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Prueba rápida de conexión desde consola o Run File en NetBeans.
 */
public class ConexionPrueba {

    public static void main(String[] args) {
        String sql = """
            SELECT e.cod_e, e.nom_e, e.dir_e, e.tel_e, e.fech_nac, c.nom_carr
            FROM Estudiantes e
            LEFT JOIN Carreras c ON e.id_carr = c.id_carr
            ORDER BY e.cod_e
            """;
        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Conexión exitosa -> " + ConexionBD.resumenConexion());
            System.out.printf("%-8s %-25s %-20s %-15s %-12s %-20s%n",
                    "Código", "Nombre", "Dirección", "Teléfono", "F. nac.", "Carrera");
            System.out.println("-".repeat(105));

            int total = 0;
            while (rs.next()) {
                Date fecha = rs.getDate("fech_nac");
                String fechaTexto = fecha != null ? fecha.toString() : "-";
                String carrera = rs.getString("nom_carr");
                if (carrera == null) {
                    carrera = "-";
                }
                String dir = rs.getString("dir_e");
                String tel = rs.getString("tel_e");

                System.out.printf("%-8d %-25s %-20s %-15s %-12s %-20s%n",
                        rs.getInt("cod_e"),
                        rs.getString("nom_e"),
                        dir != null ? dir : "-",
                        tel != null ? tel : "-",
                        fechaTexto,
                        carrera);
                total++;
            }
            System.out.println("-".repeat(105));
            System.out.println("Total estudiantes: " + total);
        } catch (Exception e) {
            System.err.println("Error de conexión:");
            e.printStackTrace();
        }
    }
}
