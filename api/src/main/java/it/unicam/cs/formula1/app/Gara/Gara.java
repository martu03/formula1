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

package it.unicam.cs.formula1.app.Gara;

import it.unicam.cs.formula1.app.Circuito.ICircuito;
import it.unicam.cs.formula1.app.Giocatori.IGiocatore;
import it.unicam.cs.formula1.app.Posizione.IPosizione;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Questa classe rappresenta una gara di Formula 1, ovvero una partita del gioco
 */
public class Gara implements IGara{

    private final ICircuito circuito;
    private final List<IGiocatore> giocatori;
    private final List<IPosizione> posizioniGiocatori;
    private boolean garaTerminata;
    private char vincitore;
    private IViewGara viewGara;

    /**
     * Costruttore per inizializzare una gara con un circuito e una lista di giocatori.

     * Inizializzo tutti i campi della classe.
     * Assegno per ogni giocatore una posizione di partenza.
     *
     * @param circuito il circuito della gara.
     * @param giocatori la lista dei giocatori che partecipano alla gara.
     */
    public Gara(ICircuito circuito, List<IGiocatore> giocatori) {
        this.circuito = circuito;
        this.giocatori = giocatori;
        this.garaTerminata = false;
        this.posizioniGiocatori = new ArrayList<>();
        this.viewGara = null;

        List<IPosizione> startLinePositions = new ArrayList<>(circuito.getStartLine());

        if (giocatori.size() > startLinePositions.size()) {
            throw new IllegalArgumentException("Non ci sono abbastanza posizioni di partenza per tutti i giocatori.");
        }

        inserisciGiocatoriStartLine(startLinePositions);
        this.vincitore = ' ';
    }

    /**
     * Inserisce i giocatori nella linea di partenza del circuito.
     *
     * @param startLinePositions la lista delle posizioni di partenza.
     */
    private void inserisciGiocatoriStartLine(List<IPosizione> startLinePositions) {
        IntStream.range(0, giocatori.size()).forEach(i -> {
            IGiocatore giocatore = giocatori.get(i);
            IPosizione posizioneGiocatore = startLinePositions.get(i);
            posizioniGiocatori.add(posizioneGiocatore);
            giocatore.setPosizioneAttuale(posizioneGiocatore);
        });
    }

    /**
     * Restituisce il circuito della gara.
     */
    @Override
    public ICircuito getCircuito() {
        return circuito;
    }

    /**
     * Restituisce i giocatori che partecipano alla gara.
     */
    @Override
    public List<IGiocatore> getGiocatori() {
        return giocatori;
    }

    /**
     * Imposta la vista della gara.
     *
     * @param garaView la vista della gara.
     */
    public void setViewGara(ViewGara garaView) {
        this.viewGara = garaView;
    }

    /**
     * Avvia la gara con i giocatori specificati.

     * Finché la gara non è terminata, avanza il turno.
     * Alla fine della gara, stampa il vincitore.
     */
    @Override
    public void avviaGara() {
        while (!garaTerminata) {
            avanzaTurno();
        }
        vincitore();
        viewGara.stampaStatoGara();

    }

    /**
     * Avanza la gara di un turno, facendo muovere tutti i giocatori.

     * Stampo lo stato della gara.
     * Per ogni giocatore, calcolo la prossima posizione e la setto come posizione attuale.
     * Se un giocatore arriva alla fine del circuito, termino la gara.
     */
    @Override
    public void avanzaTurno() {
        for (IGiocatore giocatore : giocatori) {
            viewGara.stampaStatoGara();
            posizioniGiocatori.remove(giocatore.getPosizioneAttuale());
            IPosizione posizione = giocatore.ProssimaPosizione(circuito, posizioniGiocatori);
            giocatore.setPosizioneAttuale(posizione);
            posizioniGiocatori.add(posizione);

            if (circuito.isInsideEndLine(posizione)) {
                vincitore = giocatore.getSimbolo();
                garaTerminata = true;
                break;
            }
        }

    }


    /**
     * Restituisce il giocatore vincitore.
     */
    @Override
    public void vincitore() {
        System.out.println("Il vincitore è: " + vincitore);
    }
}
