package org.inscripcion;

import org.alumno.Alumno;
import org.materia.Materia;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InscripcionTest {

    private Materia algoritmos;
    private Materia matematicaDiscreta;
    private Materia sistemasYOrganizaciones;
    private Materia arquitecturaDeComputadoras;
    private Materia paradigmasDeProgramacion;
    private Materia analisisDeSistemas;
    private Materia disenoDeSistemas;
    private Alumno cristian;

    @Before
    public void inicializarDatos() {
        //materias de primer año
        algoritmos = new Materia("Algoritmos y Estructura de Datos");
        matematicaDiscreta = new Materia("Matematica Discreta");
        sistemasYOrganizaciones = new Materia("Sistemas y Organizaciones");
        arquitecturaDeComputadoras = new Materia("Arquitectura de Computadoras");

        //materias de segundo año
        paradigmasDeProgramacion = new Materia("Paradigmas de Programacion");
        paradigmasDeProgramacion.agregarCorrelativas(algoritmos, matematicaDiscreta);

        analisisDeSistemas = new Materia("Analisis de Sistemas");
        analisisDeSistemas.agregarCorrelativas(algoritmos, sistemasYOrganizaciones);

        //  materia de tercer año
        disenoDeSistemas = new Materia("Diseño de Sistemas");
        disenoDeSistemas.agregarCorrelativas(paradigmasDeProgramacion, analisisDeSistemas);

        // crear alumno
        cristian = new Alumno("Cristian Marcelo Callahuanca");
    }

    @Test
    public void inscripcionAprobada() {
        // Cristian aprobo todas las materias necesarias
        cristian.agregarMateriasAprobadas(
                algoritmos,
                matematicaDiscreta,
                sistemasYOrganizaciones,
                arquitecturaDeComputadoras,
                paradigmasDeProgramacion,
                analisisDeSistemas
        );

        // Cristian se quiere inscribir a Diseño de Sistemas
        Inscripcion inscripcion = new Inscripcion(cristian);
        inscripcion.agregarMaterias(disenoDeSistemas);

        Assert.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void inscripcionRechazada() {
        // Cristian no aprobo Algoritmos (falta una correlativa)
        cristian.agregarMateriasAprobadas(
                matematicaDiscreta,
                sistemasYOrganizaciones,
                arquitecturaDeComputadoras,
                paradigmasDeProgramacion,
                analisisDeSistemas
        );

        // Cristian se quiere inscribir a Diseño de Sistemas
        Inscripcion inscripcion = new Inscripcion(cristian);
        inscripcion.agregarMaterias(disenoDeSistemas);

        Assert.assertFalse(inscripcion.aprobada());
    }
}
