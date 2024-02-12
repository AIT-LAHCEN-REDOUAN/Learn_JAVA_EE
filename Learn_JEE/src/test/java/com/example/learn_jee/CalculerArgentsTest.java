package com.example.learn_jee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculerArgentsTest {


    private CreditMetier metier ;


    @BeforeEach
    void setUp() {

        metier = new CreditMetier();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculerMensualite() {


        double resAttendu = 833.3333 ;

        double capital = 200000 ;
        int duree = 240 ;
        double res =  metier.CalculerMensualite(capital,duree);
        assertEquals(resAttendu,res,0.0001);
        //assertTrue(res == resAttendu);

    }
}