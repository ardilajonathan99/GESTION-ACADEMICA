package com.mycompany.gestion.academica.modelo;

public class Asignatura {

    private int codA;
    private String nomA;
    private int intH;
    private double creditos;

    public Asignatura() {
    }

    public int getCodA() {
        return codA;
    }

    public void setCodA(int codA) {
        this.codA = codA;
    }

    public String getNomA() {
        return nomA;
    }

    public void setNomA(String nomA) {
        this.nomA = nomA;
    }

    public int getIntH() {
        return intH;
    }

    public void setIntH(int intH) {
        this.intH = intH;
    }

    public double getCreditos() {
        return creditos;
    }

    public void setCreditos(double creditos) {
        this.creditos = creditos;
    }
}
