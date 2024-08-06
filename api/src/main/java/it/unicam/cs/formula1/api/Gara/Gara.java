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

package it.unicam.cs.formula1.api.Gara;

import it.unicam.cs.formula1.api.Circuito.ICircuito;
import it.unicam.cs.formula1.api.Giocatori.IGiocatore;
import it.unicam.cs.formula1.api.Posizione.IPosizione;
import it.unicam.cs.formula1.api.Posizione.Posizione;

import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe rappresenta una gara di Formula 1, ovvero una partita del gioco
 */
public class Gara implements IGara{

    private final ICircuito circuito;
    private final List<IGiocatore> giocatori;
    private final List<IPosizione> posizioniGiocatori;
    private IGiocatore vincitore;

    /**
     * Costruttore per inizializzare una gara con un circuito e una lista di giocatori.
     *
     * @param circuito il circuito della gara.
     * @param giocatori la lista dei giocatori che partecipano alla gara.
     */
    public Gara(ICircuito circuito, List<IGiocatore> giocatori) {
        this.circuito = circuito;
        this.giocatori = giocatori;
        this.posizioniGiocatori = new ArrayList<>();

        List<IPosizione> startLinePositions = new ArrayList<>(circuito.getStartLine());

        if (giocatori.size() > startLinePositions.size()) {
            throw new IllegalArgumentException("Non ci sono abbastanza posizioni di partenza per tutti i giocatori.");
        }

        for (int i = 0; i < giocatori.size(); i++) {
            IGiocatore giocatore = giocatori.get(i);
            IPosizione posizioneGiocatore = startLinePositions.get(i);
            posizioniGiocatori.add(posizioneGiocatore);
            giocatore.setPosizioneAttuale(posizioneGiocatore);
        }

        this.vincitore = null;
    }

    /**
     * Avvia la gara con i giocatori specificati.
     */
    @Override
    public void avviaGara() {
        while (!garaTerminata()) {
            avanzaTurno();
            stampaStatoGara();
        }
    }

    /**
     * Avanza la gara di un turno, facendo muovere tutti i giocatori.
     */
    @Override
    public void avanzaTurno() {
        for (IGiocatore giocatore : giocatori) {
            IPosizione posizione = giocatore.ProssimaMossa(circuito, posizioniGiocatori);
            giocatore.setPosizioneAttuale(posizione);
            if (garaTerminata()) {
                getVincitore();
                break;
            }
        }

    }

    /**
     * Verifica se la gara è terminata.
     *
     * @return true se la gara è terminata, false altrimenti.
     */
    @Override
    public boolean garaTerminata() {
        for(IGiocatore giocatore : giocatori){
            if(circuito.isInsideEndLine(giocatore.getPosizioneAttuale())){
                return true;
            }
        }
        return false;
    }

    /**
     * Restituisce il giocatore vincitore, se c'è.
     *
     * @return il giocatore vincitore, o null se non c'è ancora un vincitore.
     */
    @Override
    public IGiocatore getVincitore() {
        return null;
    }

    /**
     * Restituisce la lista dei giocatori che partecipano alla gara.
     *
     * @return la lista dei giocatori.
     */
    @Override
    public List<IGiocatore> getGiocatori() {
        return List.of();
    }

    /**
     * Stampa lo stato attuale del circuito con le posizioni dei giocatori.
     */
    @Override
    public void stampaStatoGara() {
        int larghezza = circuito.getAllPositions().stream().mapToInt(IPosizione::getX).max().orElse(0);
        int altezza = circuito.getAllPositions().stream().mapToInt(IPosizione::getY).max().orElse(0);

        char[][] griglia = stampaPista(larghezza, altezza);

        griglia = inserisciGiocatori(griglia, circuito);
        stampaGriglia(griglia);
    }

    /**
     * Inizializza la griglia di gioco con tutti 0.
     *
     * @param larghezza la larghezza della griglia.
     * @param altezza l'altezza della griglia.
     * @return la griglia di gioco inizializzata.
     */
    private char[][] stampaPista(int larghezza, int altezza) {
        char[][] griglia = new char[altezza][larghezza];

        for (int y = 0; y < altezza; y++) {
            for (int x = 0; x < larghezza; x++) {
                IPosizione posizione = new Posizione(x, y);
                if (circuito.isInsideCircuit(posizione)) {
                    if (circuito.isInsideStartLine(posizione)) {
                        griglia[y][x] = 'S'; // Posizione di partenza
                    } else if (circuito.isInsideEndLine(posizione)) {
                        griglia[y][x] = 'E'; // Posizione di arrivo
                    } else {
                        griglia[y][x] = '1'; // Posizione della pista
                    }
                } else {
                    griglia[y][x] = '0'; // Posizione fuori pista
                }
            }
        }
        return griglia;
    }

    /**
     * Inserisce i giocatori nella griglia di gioco.
     *
     * @param griglia la griglia di gioco.
     * @param circuito il circuito di gioco.
     */
    private char[][] inserisciGiocatori(char[][] griglia, ICircuito circuito) {
        for (IGiocatore giocatore : giocatori) {
            IPosizione posizione = giocatore.getPosizioneAttuale();
            int x = posizione.getX();
            int y = posizione.getY();
            griglia[y][x] = giocatore.getSimbolo(); // Posiziona il simbolo del giocatore sulla griglia
        }
        return griglia;
    }

    /**
     * Stampa la griglia di gioco.
     *
     * @param griglia la griglia di gioco.
     */
    private void stampaGriglia(char[][] griglia) {
        for (char[] riga : griglia) {
            for (char cella : riga) {
                System.out.print(cella + " "); // Stampa ogni cella con uno spazio
            }
            System.out.println(); // Vai a capo dopo ogni riga
        }
    }
}
