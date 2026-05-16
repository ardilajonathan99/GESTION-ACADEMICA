/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion.academica;

/**
 *
 * @author ardila
 */
public class Profesor extends Persona{
    private int idP;
    private String nomP;
    private String dirP;
    private String telP;
    private String profesion;

    public Profesor() {}

    // Getters y Setters
    public int getIdP() { return idP; }
    public void setIdP(int idP) { this.idP = idP; }

    public String getNomP() { return nomP; }
    public void setNomP(String nomP) { this.nomP = nomP; }

    public String getDirP() { return dirP; }
    public void setDirP(String dirP) { this.dirP = dirP; }

    public String getTelP() { return telP; }
    public void setTelP(String telP) { this.telP = telP; }

    public String getProfesion() { return profesion; }
    public void setProfesion(String profesion) { this.profesion = profesion; }
}
