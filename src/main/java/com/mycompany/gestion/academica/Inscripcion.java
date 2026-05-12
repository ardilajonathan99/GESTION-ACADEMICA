/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion.academica;

/**
 *
 * @author ardila
 */
public class Inscripcion {
private Estudiante estudiante;
    private CursoImpartido curso; 
    private double n1;
    private double n2;
    private double n3;

    public Inscripcion() {}

    public Inscripcion(Estudiante estudiante, CursoImpartido curso) {
        this.estudiante = estudiante;
        this.curso = curso;
    }

  
    public double getNotaDefinitiva() {
        return (this.n1 * 0.35) + (this.n2 * 0.35) + (this.n3 * 0.30);
    }

    // Getters y Setters
    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }

    public CursoImpartido getCurso() { return curso; }
    public void setCurso(CursoImpartido curso) { this.curso = curso; }

    public double getN1() { return n1; }
    public void setN1(double n1) { this.n1 = n1; }

    public double getN2() { return n2; }
    public void setN2(double n2) { this.n2 = n2; }

    public double getN3() { return n3; }
    public void setN3(double n3) { this.n3 = n3; }
    
    
}
