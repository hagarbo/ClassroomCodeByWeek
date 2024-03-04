package edu.hagarbo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.hagarbo.Entities.Alumno;

public class AlumnoTest {

    private Alumno alumno;

    @BeforeAll
    void init() {
        this.alumno = new Alumno();
    }

    @Test
    public void createAlumnoTest() {
        assertEquals(this.alumno, new Alumno());
    }

}
