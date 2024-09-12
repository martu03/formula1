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

import it.unicam.cs.formula1.api.mossa.Mossa2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MossaTest {

    private Mossa2D mossa;

    @BeforeEach
    void setUp() {
        // Inizializza un oggetto Mossa2D con valori iniziali dx=1 e dy=2
        mossa = new Mossa2D(1, 2);
    }

    @Test
    void testConstructor() {
        // Verifica che il costruttore imposti correttamente i valori
        List<Integer> coordinate = mossa.getCoordinate();
        assertEquals(1, coordinate.get(0), "Il valore di dx non è corretto");
        assertEquals(2, coordinate.get(1), "Il valore di dy non è corretto");
    }

    @Test
    void testGetCoordinate() {
        // Verifica che getCoordinate ritorni il valore corretto
        List<Integer> coordinate = mossa.getCoordinate();
        assertEquals(1, coordinate.get(0), "Il valore di dx non è corretto");
        assertEquals(2, coordinate.get(1), "Il valore di dy non è corretto");
    }

    @Test
    void testSetCoordinate() {
        // Modifica i valori di dx e dy con il metodo setCoordinate
        mossa.setCoordinate(List.of(3, 4));

        // Verifica che i valori siano stati aggiornati correttamente
        List<Integer> coordinate = mossa.getCoordinate();
        assertEquals(3, coordinate.get(0), "Il valore di dx non è corretto");
        assertEquals(4, coordinate.get(1), "Il valore di dy non è corretto");
    }

    @Test
    void testToString() {
        // Verifica che il metodo toString ritorni la stringa corretta
        assertEquals("Mossa2D(1, 2)", mossa.toString());

        // Cambia i valori e verifica di nuovo
        mossa.setCoordinate(List.of(5, 6));
        assertEquals("Mossa2D(5, 6)", mossa.toString());
    }
}
