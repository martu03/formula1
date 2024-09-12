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

package it.unicam.cs.formula1.api;

import it.unicam.cs.formula1.api.posizione.IPosizione;
import it.unicam.cs.formula1.api.posizione.Posizione2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test di unità per la classe Posizione2D.
 */
class PosizioneTest {

    private Posizione2D posizione;

    @BeforeEach
    void setUp() {
        // Creo una nuova posizione
        posizione = new Posizione2D(5, 10);
    }

    @Test
    void testGetCoordinate() {
        // Creo la lista delle coordinate attese
        int[] coordinateAttese = {5, 10};
        // Verifico che la lista di coordinate della posizione corrisponda a quella attesa
        assertArrayEquals(coordinateAttese, posizione.getCoordinate());
    }

    @Test
    void testGetVicini() {
        // Ottengo i vicini della posizione
        List<IPosizione> vicini = posizione.Vicini();

        // Verifico che ci siano 8 vicini
        assertEquals(8, vicini.size());

        // Lista delle posizioni attese
        Posizione2D[] posizioniAttese = {
                new Posizione2D(4, 9),
                new Posizione2D(4, 10),
                new Posizione2D(4, 11),
                new Posizione2D(5, 9),
                new Posizione2D(5, 11),
                new Posizione2D(6, 9),
                new Posizione2D(6, 10),
                new Posizione2D(6, 11)
        };

        // Verifico che i vicini siano corretti
        for (Posizione2D pos : posizioniAttese) {
            assertTrue(vicini.contains(pos), "La posizione " + pos + " dovrebbe essere tra i vicini");
        }
    }

    @Test
    void testEquals() {
        Posizione2D stessaPosizione = new Posizione2D(5, 10);
        Posizione2D diversaPosizione = new Posizione2D(3, 8);

        // Verifico che la posizione sia uguale a se stessa
        assertEquals(posizione, stessaPosizione);
        // Verifico che la posizione non sia uguale a un'altra posizione
        assertNotEquals(posizione, diversaPosizione);
    }

    @Test
    void testHashCode() {
        Posizione2D stessaPosizione = new Posizione2D(5, 10);
        // Verifico che l'hashcode sia uguale per posizioni uguali
        assertEquals(posizione.hashCode(), stessaPosizione.hashCode());
    }

    @Test
    void testToString() {
        String expectedString = "Posizione2D{x=5, y=10}";
        // Verifico che il metodo toString restituisca la stringa attesa
        assertEquals(expectedString, posizione.toString());
    }
}
