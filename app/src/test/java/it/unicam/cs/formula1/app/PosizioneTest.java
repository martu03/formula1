/*
 * MIT License
 *
 * Copyright (c) 2024 Martina Colibazzi
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.formula1.app;

import it.unicam.cs.formula1.app.Posizione.IPosizione;
import it.unicam.cs.formula1.app.Posizione.Posizione;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test di unità per la classe Posizione.
 */
class PosizioneTest {

    private Posizione posizione;

    @BeforeEach
    void setUp() {
        // Creo una nuova posizione
        posizione = new Posizione(5, 10);
    }

    @Test
    void testGetX() {
        //Verifico che la variabile x corrisponda al valore della posizione
        assertEquals(5, posizione.getX());
    }

    @Test
    void testGetY() {
        //Verifico che la variabile y corrisponda al valore della posizione
        assertEquals(10, posizione.getY());
    }

    @Test
    void testGetOttoVicini() {
        // Ottengo i vicini della posizione
        List<IPosizione> vicini = posizione.getOttoVicini();

        // Verifico che ci siano 8 vicini
        assertEquals(8, vicini.size());

        // Lista delle posizioni attese
        Posizione[] posizioniAttese = {
                new Posizione(4, 9),
                new Posizione(4, 10),
                new Posizione(4, 11),
                new Posizione(5, 9),
                new Posizione(5, 11),
                new Posizione(6, 9),
                new Posizione(6, 10),
                new Posizione(6, 11)
        };

        // Verifico che i vicini siano corretti
        for (Posizione pos : posizioniAttese) {
            assertTrue(vicini.contains(pos), "La posizione " + pos + " dovrebbe essere tra i vicini");
        }
    }

    @Test
    void testEquals() {
        Posizione stessaPosizione = new Posizione(5, 10);
        Posizione diversaPosizione = new Posizione(3, 8);

        // Verifico che la posizione sia uguale a se stessa
        assertEquals(posizione, stessaPosizione);
        // Verifico che la posizione non sia uguale a un'altra posizione
        assertNotEquals(posizione, diversaPosizione);
    }

    @Test
    void testHashCode() {
        Posizione stessaPosizione = new Posizione(5, 10);
        // Verifico che l'hashcode sia uguale per posizioni uguali
        assertEquals(posizione.hashCode(), stessaPosizione.hashCode());
    }

    @Test
    void testToString() {
        String expectedString = "Posizione{x=5, y=10}";
        // Verifico che il metodo toString restituisca la stringa attesa
        assertEquals(expectedString, posizione.toString());
    }
}
