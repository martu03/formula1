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

package it.unicam.cs.formula1.app.Giocatori;

import it.unicam.cs.formula1.app.Circuito.ICircuito;
import it.unicam.cs.formula1.app.Posizione.IPosizione;

import java.util.List;

/**
 * Questa interfaccia rappresenta un giocatore.
 */
public interface IGiocatore {

    /**
     * Ritorna il simbolo associato al giocatore.
     *
     * @return il simbolo del giocatore.
     */
    char getSimbolo();

    /**
     * Ritorna la posizione attuale del giocatore.
     *
     * @return la posizione attuale del giocatore.
     */
    IPosizione getPosizioneAttuale();

    /**
     * Ritorna l'ultima mossa compiuta dal giocatore.
     *
     * @return l'ultima mossa compiuta dal giocatore.
     */
    Mossa getUltimaMossa();

    /**
     * Imposta la posizione attuale del giocatore.
     *
     * @param posizioneAttuale la posizione attuale del giocatore.
     */
    void setPosizioneAttuale(IPosizione posizioneAttuale);

    /**
     * Imposta l'ultima mossa compiuta dal giocatore.
     *
     * @param posizioneScelta posizione scelta dal giocatore.
     */
    void setUltimaMossa(IPosizione posizioneScelta);

    /**
     * Ritorna la prossima mossa del giocatore.
     *
     * @param circuito il circuito su cui si sta giocando.
     * @param posizioniGiocatori le posizioni dei giocatori.
     * @return la prossima mossa del giocatore.
     */
    IPosizione ProssimaPosizione(ICircuito circuito, List<IPosizione> posizioniGiocatori);

    /**
     * Ritorna le posizioni raggiungibili dal giocatore.
     *
     * @param circuito il circuito su cui si sta giocando.
     * @param posizioniGiocatori le posizioni dei giocatori.
     * @return le posizioni raggiungibili dal giocatore.
     */
    List<IPosizione> getPosizioniRaggiungibili(ICircuito circuito, List<IPosizione> posizioniGiocatori);
}
