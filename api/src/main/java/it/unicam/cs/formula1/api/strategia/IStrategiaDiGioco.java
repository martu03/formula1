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

package it.unicam.cs.formula1.api.strategia;

import it.unicam.cs.formula1.api.circuito.ICircuito;
import it.unicam.cs.formula1.api.giocatore.IGiocatore;
import it.unicam.cs.formula1.api.posizione.IPosizione;

import java.util.List;

/**
 * Questa interfaccia è implementata dalle classi che rappresentano le strategie di gioco
 * che i giocatori possono scegliere per muovere il proprio veicolo.
 */
public interface IStrategiaDiGioco {

    /**
     * Restituisce la lista delle posizioni in cui il veicolo può muoversi.
     *
     * @param giocatore il giocatore che sta giocando
     * @param circuito il circuito su cui si sta giocando
     * @param posizioniGiocatori la lista delle posizioni dei veicoli dei giocatori
     * @return la lista delle posizioni in cui il veicolo può muoversi
     */
    List<IPosizione> possibiliPosizioni(IGiocatore giocatore,
                                        ICircuito circuito, List<IPosizione> posizioniGiocatori);
}
