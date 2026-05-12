/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion.academica;

/**
 *
 * @author ardila
 */
public class Asignatura {
    private int codA;
    private String nomA;
    private int intH;
    private double creditos;

    public Asignatura() {}

    // Getters y Setters
    public int getCodA() { return codA; }
    public void setCodA(int codA) { this.codA = codA; }

    public String getNomA() { return nomA; }
    public void setNomA(String nomA) { this.nomA = nomA; }

    public int getIntH() { return intH; }
    public void setIntH(int intH) { this.intH = intH; }

    public double getCreditos() { return creditos; }
    public void setCreditos(double creditos) { this.creditos = creditos; }
}
