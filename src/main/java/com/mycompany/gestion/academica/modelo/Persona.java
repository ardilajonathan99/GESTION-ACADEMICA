package com.mycompany.gestion.academica.modelo;

public abstract class Persona {

    private int codE;
    private String nomE;
    private String dirE;
    private String telE;

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
}
