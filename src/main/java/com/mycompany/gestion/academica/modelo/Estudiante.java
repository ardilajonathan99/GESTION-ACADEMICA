package com.mycompany.gestion.academica.modelo;

import java.util.Date;

public class Estudiante extends Persona {

    private int codE;
    private String nomE;
    private String dirE;
    private String telE;
    private Date fechNac;
    private Carrera carrera;

    public Estudiante() {
    }

    public Estudiante(int codE, String nomE, String dirE, String telE, Date fechNac, Carrera carrera) {
        this.codE = codE;
        this.nomE = nomE;
        this.dirE = dirE;
        this.telE = telE;
        this.fechNac = fechNac;
        this.carrera = carrera;
    }

    public int getCodE() {
        return codE;
    }

    public void setCodE(int codE) {
        this.codE = codE;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getDirE() {
        return dirE;
    }

    public void setDirE(String dirE) {
        this.dirE = dirE;
    }

    public String getTelE() {
        return telE;
    }

    public void setTelE(String telE) {
        this.telE = telE;
    }

    public Date getFechNac() {
        return fechNac;
    }

    public void setFechNac(Date fechNac) {
        this.fechNac = fechNac;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
