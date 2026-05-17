package com.mycompany.gestion.academica.modelo;

public class Carrera {

    private int idCarr;
    private String nomCarr;
    private String regCalif;

    public Carrera() {
    }

    public Carrera(int idCarr, String nomCarr, String regCalif) {
        this.idCarr = idCarr;
        this.nomCarr = nomCarr;
        this.regCalif = regCalif;
    }

    public int getIdCarr() {
        return idCarr;
    }

    public void setIdCarr(int idCarr) {
        this.idCarr = idCarr;
    }

    public String getNomCarr() {
        return nomCarr;
    }

    public void setNomCarr(String nomCarr) {
        this.nomCarr = nomCarr;
    }

    public String getRegCalif() {
        return regCalif;
    }

    public void setRegCalif(String regCalif) {
        this.regCalif = regCalif;
    }
}
