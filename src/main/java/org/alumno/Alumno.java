package org.alumno;

import org.materia.Materia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private String nombre;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.materiasAprobadas = new ArrayList<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public boolean aprobo(Materia materia) {
        return materiasAprobadas.contains(materia);
    }

    public void agregarMateriasAprobadas(Materia... materias) {
        Collections.addAll(this.materiasAprobadas, materias);
    }
}
