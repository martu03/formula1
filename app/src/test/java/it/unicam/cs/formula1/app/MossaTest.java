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

import it.unicam.cs.formula1.app.Giocatori.Mossa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MossaTest {

    private Mossa mossa;

    @BeforeEach
    void setUp() {
        // Inizializza un oggetto Mossa con valori iniziali dx=1 e dy=2
        mossa = new Mossa(1, 2);
    }

    @Test
    void testConstructor() {
        // Verifica che il costruttore imposti correttamente i valori
        assertEquals(1, mossa.getDx(), "Il valore di dx non è corretto");
        assertEquals(2, mossa.getDy(), "Il valore di dy non è corretto");
    }

    @Test
    void testGetDx() {
        // Verifica che getDx ritorni il valore corretto
        assertEquals(1, mossa.getDx());
    }

    @Test
    void testGetDy() {
        // Verifica che getDy ritorni il valore corretto
        assertEquals(2, mossa.getDy());
    }

    @Test
    void testSetMossa() {
        // Modifica i valori di dx e dy con il metodo setMossa
        mossa.setMossa(3, 4);

        // Verifica che i valori siano stati aggiornati correttamente
        assertEquals(3, mossa.getDx());
        assertEquals(4, mossa.getDy());
    }

    @Test
    void testToString() {
        // Verifica che il metodo toString ritorni la stringa corretta
        assertEquals("Mossa(1, 2)", mossa.toString());

        // Cambia i valori e verifica di nuovo
        mossa.setMossa(5, 6);
        assertEquals("Mossa(5, 6)", mossa.toString());
    }
}
