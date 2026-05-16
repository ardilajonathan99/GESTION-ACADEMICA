/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion.academica;

/**
 *
 * @author Estudiantes
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionAWS {

    // Datos de tu instancia en AWS RDS
    private static final String HOST = "gestion-academica.cm7o0yekoeve.us-east-1.rds.amazonaws.com";
    private static final String PORT = "5432";
    private static final String DATABASE = "postgres"; // Cambiar por 'gestion-academica' si creaste un contenedor específico
    private static final String USER = "postgres";
    private static final String PASSWORD = "Informatica2026"; // Coloca aquí la contraseña real

    // URL de conexión JDBC para PostgreSQL
    private static final String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;

    public static Connection conectar() {
        Connection conexion = null;
        try {
            // Registrar el driver de PostgreSQL (opcional en versiones modernas de Java, pero buena práctica)
            Class.forName("org.postgresql.Driver");
            
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("¡Conexión exitosa a la base de datos en AWS RDS!");
            
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver JDBC de PostgreSQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error de conexión al servidor de AWS. Verifica credenciales o el Security Group.");
            e.printStackTrace();
        }
        return conexion;
    }

    public static void main(String[] args) {
        // Prueba de conexión de ejecución directa
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
