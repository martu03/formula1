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
import java.util.Random;

/**
 * Questa classe rappresenta un giocatore bot o robot.
 */
public class GiocatoreBot extends GiocatoreBase {

    /**
     * Costruttore che inizializza un giocatore bot con il simbolo fornito.
     *
     * @param simbolo Il simbolo del giocatore.
     */
    public GiocatoreBot(char simbolo) {
        super(simbolo);
    }

    /**
     * Ritorna la prossima mossa del giocatore.

     * Prima si calcolano le posizioni Possibili in cui il bot può muoversi.
     * Tramite un oggetto Random si sceglie una posizione casuale tra quelle possibili.
     * Si modifica il valore dell'ultima mossa.
     * Restituisce la posizione scelta casualmente.
     *
     * @param circuito il circuito su cui si sta giocando.
     * @param posizioniGiocatori le posizioni dei giocatori.
     * @return la prossima mossa del giocatore.
     */
    @Override
    public IPosizione ProssimaPosizione(ICircuito circuito, List<IPosizione> posizioniGiocatori) {
        List<IPosizione> posizioniPossibili = getPosizioniRaggiungibili(circuito, posizioniGiocatori);

        Random random = new Random();
        int sceltaRandom = random.nextInt(posizioniPossibili.size());

        this.setUltimaMossa(posizioniPossibili.get(sceltaRandom));

        return posizioniPossibili.get(sceltaRandom);
    }

}
