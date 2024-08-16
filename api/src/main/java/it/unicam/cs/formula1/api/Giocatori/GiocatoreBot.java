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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GiocatoreBot implements IGiocatore{

    private final char simbolo;
    private IPosizione posizioneAttuale;
    private Mossa puntoPrinciale;
    //DEVO AGGIUNGERE IL CONCETTO DI PUNTO PRINCIPALE

    /**
     * Costruttore che crea un giocatore robot.
     *
     * @param simbolo Simbolo associato al giocatore.
     */
    public GiocatoreBot(char simbolo){
        this.simbolo = simbolo;
        this.posizioneAttuale = null;
        this.puntoPrinciale = new Mossa(0, 0);
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
     * Ritorna il punto principale del giocatore.
     *
     * @return il punto principale del giocatore.
     */
    @Override
    public Mossa getUltimaMossa() {
        return puntoPrinciale;
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
     * Imposta il punto principale del giocatore.
     *
     * @param ultimaMossa il punto principale del giocatore.
     */
    @Override
    public void setUltimaMossa(Mossa ultimaMossa) {
        this.puntoPrinciale = ultimaMossa;
    }


    /**
     * Ritorna la prossima mossa del giocatore.
     *
     * @param circuito
     * @param posizioniGiocatori
     * @return la prossima mossa del giocatore.
     */
    @Override
    public IPosizione ProssimaPosizione(ICircuito circuito, List<IPosizione> posizioniGiocatori) {
        List<IPosizione> posizioniPossibili = getPosizioniRaggiungibili(circuito, posizioniGiocatori);

        Random random = new Random();
        int sceltaRandom = random.nextInt(posizioniPossibili.size());

        return posizioniPossibili.get(sceltaRandom);
    }

    /**
     * Ritorna le posizioni raggiungibili dal giocatore.
     *
     * @param circuito
     * @param posizioniGiocatori
     * @return le posizioni raggiungibili dal giocatore.
     */
    @Override
    public List<IPosizione> getPosizioniRaggiungibili(ICircuito circuito, List<IPosizione> posizioniGiocatori) {
        IPosizione[] ottoVicini = posizioneAttuale.getOttoVicini();
        List<IPosizione> posizioniPossibili = new ArrayList<>();
        for (IPosizione posizione : ottoVicini) {
            if(circuito.isInsideCircuit(posizione) && !posizioniGiocatori.contains(posizione)){
                posizioniPossibili.add(posizione);
            }
        }
        return posizioniPossibili;
    }

}
