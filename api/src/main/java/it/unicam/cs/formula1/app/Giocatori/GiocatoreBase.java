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
import it.unicam.cs.formula1.app.Posizione.Posizione;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe astratta che rappresenta un giocatore generico in un gioco di corse.
 */
public abstract class GiocatoreBase implements IGiocatore {
    protected final char simbolo;
    protected IPosizione posizioneAttuale;
    protected Mossa ultimaMossa;

    /**
     * Costruttore che inizializza un giocatore base con il simbolo fornito.
     *
     * @param simbolo Il simbolo del giocatore.
     */
    public GiocatoreBase(char simbolo) {
        this.simbolo = simbolo;
        this.posizioneAttuale = null;
        this.ultimaMossa = new Mossa(0, 0);
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
     * Ritorna l'ultima mossa compiuta dal giocatore.
     *
     * @return l'ultima mossa compiuta dal giocatore.
     */
    @Override
    public Mossa getUltimaMossa() {
        return ultimaMossa;
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
     * Imposta l'ultima mossa compiuta dal giocatore.
     *
     * @param posizioneScelta posizione scelta dal giocatore.
     */
    @Override
    public void setUltimaMossa(IPosizione posizioneScelta) {
        int dx = posizioneScelta.getX() - this.posizioneAttuale.getX();
        int dy = posizioneScelta.getY() - this.posizioneAttuale.getY();

        this.ultimaMossa.setMossa(dx, dy);
    }

    /**
     * Ritorna le posizioni raggiungibili dal giocatore bot.

     * Inizialmente si calcola il punto principale del giocatore.
     * Poi si ottengono gli otto vicini del punto principale.
     * Si aggiungono alla lista delle posizioni possibili solo le posizioni che sono all'interno
     * del circuito e che non sono occupate da altri giocatori.
     * Restituisce la lista delle posizioni possibili.
     *
     * @param circuito il circuito su cui si sta giocando.
     * @param posizioniGiocatori le posizioni dei giocatori.
     * @return le posizioni raggiungibili dal giocatore.
     */
    @Override
    public List<IPosizione> getPosizioniRaggiungibili(ICircuito circuito, List<IPosizione> posizioniGiocatori) {
        IPosizione puntoPrincipale = calcolaPuntoPrincipale();
        List<IPosizione> ottoVicini = new ArrayList<>();

        //controllo se devo calcolare gli otto vicini del punto principale o della posizione attuale
        if(circuito.isInsideCircuit(puntoPrincipale))
            ottoVicini = puntoPrincipale.getOttoVicini();
        else
            ottoVicini = posizioneAttuale.getOttoVicini();

        List<IPosizione> posizioniPossibili = new ArrayList<>();

        if(!puntoPrincipale.equals(posizioneAttuale)) {
            ottoVicini.add(puntoPrincipale);
            ottoVicini.remove(posizioneAttuale);
        }

        for (IPosizione posizione : ottoVicini) {
            if(circuito.isInsideCircuit(posizione) && !(posizioniGiocatori.contains(posizione)) ){
                posizioniPossibili.add(posizione);
            }
        }

        return posizioniPossibili;
    }

    /**
     * Calcola il punto principale del giocatore.
     *
     * @return la nuova posizione principale.
     */
    protected IPosizione calcolaPuntoPrincipale() {
        int x = this.posizioneAttuale.getX() + this.ultimaMossa.getDx();
        int y = this.posizioneAttuale.getY() + this.ultimaMossa.getDy();

        return new Posizione(x, y);
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

