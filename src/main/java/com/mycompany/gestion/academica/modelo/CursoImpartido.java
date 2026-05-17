package com.mycompany.gestion.academica.modelo;

public class CursoImpartido {

    private Profesor profesor;
    private Asignatura asignatura;
    private String grupo;
    private String horario;

    public CursoImpartido() {
    }

    public CursoImpartido(Profesor profesor, Asignatura asignatura, String grupo, String horario) {
        this.profesor = profesor;
        this.asignatura = asignatura;
        this.grupo = grupo;
        this.horario = horario;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
