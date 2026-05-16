/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Estudiantes
 */
package com.mycompany.gestion.academica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProbarDatos {

    public static void main(String[] args) {
        // Consulta SQL para traer el código del estudiante, la asignatura y su nota final
        String sql = "SELECT cod_e, cod_a, definitiva FROM vw_notas_definitivas;";

        // Usamos el método conectar() de tu clase ConexionAWS
        try (Connection conn = ConexionAWS.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- DATOS DE PROCESO ACADÉMICO EN AWS ---");
            System.out.printf("%-15s %-15s %-10s\n", "Cod. Estudiante", "Cod. Asignatura", "Definitiva");
            System.out.println("---------------------------------------------------");

            // Recorrer los registros devueltos por la base de datos
            while (rs.next()) {
                int codEstudiante = rs.getInt("cod_e");
                int codAsignatura = rs.getInt("cod_a");
                double definitiva = rs.getDouble("definitiva");

                System.out.printf("%-15d %-15d %-10.2f\n", codEstudiante, codAsignatura, definitiva);
            }

        } catch (Exception e) {
            System.err.println("Error al leer los datos de la nube:");
            e.printStackTrace();
        }
    }
}