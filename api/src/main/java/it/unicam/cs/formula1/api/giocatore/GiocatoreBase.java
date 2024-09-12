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

package it.unicam.cs.formula1.api.giocatore;

import it.unicam.cs.formula1.api.circuito.ICircuito;
import it.unicam.cs.formula1.api.posizione.IPosizione;
import it.unicam.cs.formula1.api.strategia.IStrategiaDiGioco;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe astratta che rappresenta un giocatore generico in un gioco di corse.
 */
public abstract class GiocatoreBase implements IGiocatore {
    protected final char simbolo;
    protected IPosizione posizioneAttuale;
    protected IStrategiaDiGioco strategiaDiGioco;

    /**
     * Costruttore che inizializza un giocatore base con il simbolo fornito.
     *
     * @param simbolo Il simbolo del giocatore.
     */
    public GiocatoreBase(char simbolo, IStrategiaDiGioco strategiaDiGioco) {
        this.simbolo = simbolo;
        this.posizioneAttuale = null;
        this.strategiaDiGioco = strategiaDiGioco;
    }

    /**
     * Ritorna il simbolo associato al giocatore.
     *
     * @return il simbolo del giocatore.
     */
    @Override
    public char getSimbolo() {
        return simbolo;
    }

    /**
     * Ritorna la posizione attuale del giocatore.
     *
     * @return la posizione attuale del giocatore.
     */
    @Override
    public IPosizione getPosizioneAttuale() {
        return posizioneAttuale;
    }

    /**
     * Imposta la posizione attuale del giocatore.
     *
     * @param posizioneAttuale la posizione attuale del giocatore.
     */
    @Override
    public void setPosizioneAttuale(IPosizione posizioneAttuale) {
        this.posizioneAttuale = posizioneAttuale;
    }

    /**
     * Ritorna la prossima mossa del giocatore.
     *
     * @param circuito il circuito su cui si sta giocando.
     * @param posizioniGiocatori le posizioni dei giocatori.
     * @return la prossima mossa del giocatore.
     */
    @Override
    public abstract IPosizione ProssimaPosizione(ICircuito circuito, List<IPosizione> posizioniGiocatori);
}

