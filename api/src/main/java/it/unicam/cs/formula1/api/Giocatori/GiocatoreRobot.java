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

package it.unicam.cs.formula1.api.Giocatori;

import it.unicam.cs.formula1.api.Circuito.ICircuito;
import it.unicam.cs.formula1.api.Posizione.IPosizione;

public class GiocatoreRobot implements IGiocatore{

    private final char simbolo;
    private IPosizione posizioneAttuale;

    /**
     * Costruttore che crea un giocatore robot.
     *
     * @param simbolo Simbolo associato al giocatore.
     */
    public GiocatoreRobot(char simbolo){
        this.simbolo = simbolo;
        this.posizioneAttuale = null;
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
     * Imposta la posizione attuale del giocatore.
     *
     * @param posizioneAttuale la posizione attuale del giocatore.
     */
    @Override
    public void setPosizioneAttuale(IPosizione posizioneAttuale) {
        this.posizioneAttuale = posizioneAttuale;
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
     * Determina la prossima mossa del giocatore.
     *
     * @param circuito
     * @param posizioneAttuale
     * @return la prossima mossa del giocatore.
     */
    @Override
    public IPosizione ProssimaMossa(ICircuito circuito, IPosizione posizioneAttuale) {
        //la prossima mossa è scelta casualmente tra quelle possibili determinate dal
        //metodo getPosizioniRaggiungibili
        return null;
    }

    /**
     * Ritorna le posizioni raggiungibili dal giocatore.
     *
     * @param circuito
     * @param posizioneAttuale
     * @return le posizioni raggiungibili dal giocatore.
     */
    @Override
    public IPosizione[] getPosizioniRaggiungibili(ICircuito circuito, IPosizione posizioneAttuale) {
        //le posizioni raggiungibili sono calcolate in base alla posizione attuale del giocatore
        return new IPosizione[0];
    }
}
