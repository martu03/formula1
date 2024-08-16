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

/**
 * Questa classe ha il compito di visualizzare lo stato della gara.
 */
public class ViewGara implements IViewGara {

    private final IGara gara;

    /**
     * Costruttore per inizializzare la gara.
     *
     * @param gara la gara da visualizzare.
     */
    public ViewGara(IGara gara) {
        this.gara = gara;
    }

    /**
     * Stampa lo stato attuale del circuito con le posizioni dei giocatori.

     * Prende le dimensioni del circuito calcolando il massimo valore di x e y tra tutte le posizioni.
     * Crea una griglia di gioco
     * All'inizio viene stampata la pista con le posizioni di partenza e arrivo.
     * Poi vengono inseriti i giocatori.
     */
    @Override
    public void stampaStatoGara() {
        ICircuito circuito = gara.getCircuito();

        int larghezza = circuito.getAllPositions().stream().mapToInt(IPosizione::getX).max().orElse(0);
        int altezza = circuito.getAllPositions().stream().mapToInt(IPosizione::getY).max().orElse(0);
        char[][] griglia = stampaPista(larghezza + 1, altezza + 1);

        griglia = inserisciGiocatori(griglia);
        stampaGriglia(griglia);

        System.out.println("-----------------------------------");
    }

    /**
     * Stampo la pista

     * Creo delle posizioni che comporranno la griglia di gioco.
     * Per ognuna controllo se è dentro il circuito, se è sulla linea di partenza o di arrivo;
     * e in base a queste informazioni assegno un simbolo alla posizione.
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
                if (gara.getCircuito().isInsideCircuit(posizione)) {
                    if (gara.getCircuito().isInsideStartLine(posizione)) {
                        griglia[y][x] = 'S'; // Posizione di partenza
                    } else if (gara.getCircuito().isInsideEndLine(posizione)) {
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
     */
    private char[][] inserisciGiocatori(char[][] griglia) {
        for (IGiocatore giocatore : gara.getGiocatori()) {
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
