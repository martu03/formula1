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
import it.unicam.cs.formula1.api.strategia.StrategiaPuntoPrincipale;
import it.unicam.cs.formula1.api.strategia.StrategiaOttoVicini;

import java.util.List;
import java.util.Scanner;

/**
 * Questa classe rappresenta un giocatore umano.
 */
public class GiocatoreUmano extends GiocatoreBase {

    /**
     * Costruttore che inizializza un giocatore umano con il simbolo fornito.
     *
     * @param simbolo Il simbolo del giocatore.
     */
    public GiocatoreUmano(char simbolo, IStrategiaDiGioco strategiaDiGioco) {
        super(simbolo, strategiaDiGioco);
    }

    /**
     * Ritorna la prossima mossa del giocatore.

     * Se il circuito è nullo, restituisce la posizione attuale del giocatore.
     * Altrimenti si calcolano le posizioni Possibili in cui il bot può muoversi in base alla strategia di gioco.
     * Si chiede all'utente di selezionare la prossima posizione tra le posizioni possibili; questo avviene
     * attraverso uno scanner che legge l'input dell'utente.
     *
     * Se la strategia utilizzata utilizza il concetto di Mossa2D, quest'ultima deve essere aggiornata.
     * Restituisce la posizione scelta dall'utente.
     *
     * @param circuito il circuito su cui si sta giocando.
     * @param posizioniGiocatori le posizioni dei giocatori.
     * @return la prossima posizione del giocatore.
     */
    @Override
    public IPosizione ProssimaPosizione(ICircuito circuito, List<IPosizione> posizioniGiocatori) {
        if (circuito == null) {
            return getPosizioneAttuale();
        }

        List<IPosizione> posizioniPossibili = strategiaDiGioco.possibiliPosizioni(
                this, circuito, posizioniGiocatori);

        //gestione input dell'utente
        System.out.println("Seleziona la prossima posizione tra le seguenti:");
        for (int i = 0; i < posizioniPossibili.size(); i++) {
            System.out.println(i + ": " + posizioniPossibili.get(i).toString());
        }

        Scanner scanner = new Scanner(System.in);
        int scelta = -1;

        while (scelta < 0 || scelta >= posizioniPossibili.size()) {
            System.out.print("Inserisci il numero della posizione scelta: ");
            if (scanner.hasNextInt()) {
                scelta = scanner.nextInt();
                if (scelta < 0 || scelta >= posizioniPossibili.size()) {
                    System.out.println("Scelta non valida. Riprova.");
                }
            } else {
                System.out.println("Input non valido. Inserisci un numero.");
                scanner.next();
            }
        }

        IPosizione posizioneScelta = posizioniPossibili.get(scelta);

        if (strategiaDiGioco instanceof StrategiaPuntoPrincipale) {
            ((StrategiaPuntoPrincipale) strategiaDiGioco).setUltimaMossa(posizioneScelta, this);
        }

        return posizioneScelta;
    }

}

