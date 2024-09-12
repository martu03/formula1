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

import it.unicam.cs.formula1.api.giocatore.GiocatoreBot;
import it.unicam.cs.formula1.api.posizione.IPosizione;
import it.unicam.cs.formula1.api.posizione.Posizione2D;

import it.unicam.cs.formula1.api.strategia.IStrategiaDiGioco;
import it.unicam.cs.formula1.api.strategia.StrategiaPuntoPrincipale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test di unità per la classe GiocatoreBase.
 */
public class GiocatoreBaseTest {

    private GiocatoreBot giocatore;
    private IPosizione posizioneAttuale;

    @BeforeEach
    void setUp() {
        // Creo la strategia di gioco fittizia per i test
        IStrategiaDiGioco strategiaDiGioco = new StrategiaPuntoPrincipale() {
            // Implementa metodi della strategia se necessario
        };

        // Creo il nuovo giocatore
        giocatore = new GiocatoreBot('B', strategiaDiGioco);
        posizioneAttuale = new Posizione2D(0, 0);
        giocatore.setPosizioneAttuale(posizioneAttuale);
    }

    @Test
    void testGetSimbolo() {
        // Verifica che il simbolo sia lo stesso
        assertEquals('B', giocatore.getSimbolo());
    }

    @Test
    void testGetPosizioneAttuale() {
        // Verifica che la posizione attuale sia la stessa
        assertEquals(posizioneAttuale, giocatore.getPosizioneAttuale());
    }

    @Test
    void testSetPosizioneAttuale() {
        // Creo una nuova posizione e la setto come posizione attuale
        IPosizione nuovaPosizione = new Posizione2D(1, 1);
        giocatore.setPosizioneAttuale(nuovaPosizione);
        // Verifica che la posizione attuale sia stata cambiata
        assertEquals(nuovaPosizione, giocatore.getPosizioneAttuale());
    }


    @Test
    void testProssimaPosizione() {
        // Test per il metodo astratto ProssimaPosizione
        IPosizione posizioneDesiderata = new Posizione2D(0, 0);
        // Il metodo ProssimaPosizione dovrebbe restituire la posizione attuale nel nostro caso
        assertEquals(posizioneDesiderata, giocatore.ProssimaPosizione(null, null));
    }


}
