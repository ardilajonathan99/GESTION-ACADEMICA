/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion.academica;

/**
 *
 * @author ardila
 */
public class Carrera {
    private int idCarr;
    private String nomCarr;
    private String regCalif;

    public Carrera() {}

    public Carrera(int idCarr, String nomCarr, String regCalif) {
        this.idCarr = idCarr;
        this.nomCarr = nomCarr;
        this.regCalif = regCalif;
    }

    // Getters y Setters
    public int getIdCarr() { return idCarr; }
    public void setIdCarr(int idCarr) { this.idCarr = idCarr; }

    public String getNomCarr() { return nomCarr; }
    public void setNomCarr(String nomCarr) { this.nomCarr = nomCarr; }

    public String getRegCalif() { return regCalif; }
    public void setRegCalif(String regCalif) { this.regCalif = regCalif; }
}
