package org.example.pointageEmploye.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class EmployeTest {
    private Employe rakoto;
    private Employe rabe;
    @BeforeEach
    void setUp(){
        Category gardien = new Category("gardien", 56, 100000.0,  0.0, Collections.emptyList());
        rakoto = new Employe("Rakoto", "Jean", "123", Instant.now(), Instant.now(), null, 110000, gardien);
        rabe = new Employe("Rabe", "Pierre", "124", Instant.now(), Instant.now(), null, 110000, gardien);
    }
    @Test
    void calculateSalaryNet() {
        assertEquals(88000.0, rakoto.calculateSalaryNet());
        assertEquals(88000.0, rabe.calculateSalaryNet());
    }

    @Test
    void calculateAdditionalHour() {
        rakoto.addPointing(new Pointing(rakoto, LocalTime.of(8,0),LocalTime.of(16,0),Instant.now()));
        assertEquals(8-56, rakoto.calculateAdditionalHour());
    }

    @Test
    void addPointing() {
    }
}