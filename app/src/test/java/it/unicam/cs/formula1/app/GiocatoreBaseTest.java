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

import it.unicam.cs.formula1.app.Giocatori.GiocatoreBot;
import it.unicam.cs.formula1.app.Giocatori.Mossa;
import it.unicam.cs.formula1.app.Posizione.IPosizione;
import it.unicam.cs.formula1.app.Posizione.Posizione;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test di unità per la classe GiocatoreBase.
 */
public class GiocatoreBaseTest {

    private GiocatoreBot giocatore;
    private IPosizione posizioneAttuale;
    private Mossa ultimaMossa;

    @BeforeEach
    void setUp() {
        //creo il nuovo giocatore
        giocatore = new GiocatoreBot('B');
        posizioneAttuale = new Posizione(0, 0);
        giocatore.setPosizioneAttuale(posizioneAttuale);
        ultimaMossa = new Mossa(0, 0);
    }

    @Test
    void testGetSimbolo() {
        //Verifica che il simbolo sia lo stesso
        assertEquals('B', giocatore.getSimbolo());
    }

    @Test
    void testGetPosizioneAttuale() {
        //Verifica che la posizione attuale sia la stessa
        assertEquals(posizioneAttuale, giocatore.getPosizioneAttuale());
    }

    @Test
    void testSetPosizioneAttuale() {
        //Creo una nuova posizione e la setto come posizione attuale
        IPosizione nuovaPosizione = new Posizione(1, 1);
        giocatore.setPosizioneAttuale(nuovaPosizione);
        //Verifica che la posizione attuale sia stata cambiata
        assertEquals(nuovaPosizione, giocatore.getPosizioneAttuale());
    }

    @Test
    void testSetUltimaMossa() {
        //Setto la posizione attuale
        IPosizione posizioneAttuale = new Posizione(1, 0);
        giocatore.setPosizioneAttuale(posizioneAttuale);

        //Setto la posizione desiderata (dove vuole dirigersi il giocatore)
        IPosizione posizioneDesiderata = new Posizione(2, 3);
        giocatore.setUltimaMossa(posizioneDesiderata);

        //Verifica che l'ultima mossa sia stata settata correttamente
        assertEquals(1, giocatore.getUltimaMossa().getDx());
        assertEquals(3, giocatore.getUltimaMossa().getDy());
    }

}
