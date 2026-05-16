/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion.academica;
import java.util.Date;
/**
 *
 * @author ardila
 */
public class Estudiante extends Persona {
    private int codE;
    private String nomE;
    private String dirE;
    private String telE;
    private Date fechNac;
    private Carrera carrera; // Relación con el objeto Carrera

    public Estudiante(int codE, String nomE, String dirE, String telE, Date fechNac, Carrera carrera) {
        this.codE = codE;
        this.nomE = nomE;
        this.dirE = dirE;
        this.telE = telE;
        this.fechNac = fechNac;
        this.carrera = carrera;
    }
 
    
    public Estudiante() {}

    // Getters y Setters
    public int getCodE() { return codE; }
    public void setCodE(int codE) { this.codE = codE; }

    public String getNomE() { return nomE; }
    public void setNomE(String nomE) { this.nomE = nomE; }

    public Carrera getCarrera() { return carrera; }
    public void setCarrera(Carrera carrera) { this.carrera = carrera; }

    public String getDirE() {return dirE;}

    public void setDirE(String dirE) {this.dirE = dirE;}

    public String getTelE() {return telE;}

    public void setTelE(String telE) {this.telE = telE;}

    public Date getFechNac() {return fechNac;}

    public void setFechNac(Date fechNac) {this.fechNac = fechNac;}
    
    
}
