package org.inscripcion;

import org.alumno.Alumno;
import org.materia.Materia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materias = new ArrayList<>();
    }

    public void agregarMaterias(Materia... materias) {
        Collections.addAll(this.materias, materias);
    }

    public boolean aprobada() {
        return this.materias
                .stream()
                .allMatch(materia ->
                        materia.getCorrelativas()
                                .stream()
                                .allMatch(correlativa -> alumno.aprobo(correlativa))
                );
    }
}
