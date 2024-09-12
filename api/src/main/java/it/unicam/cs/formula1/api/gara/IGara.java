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

package it.unicam.cs.formula1.api.gara;

import it.unicam.cs.formula1.api.circuito.ICircuito;
import it.unicam.cs.formula1.api.giocatore.IGiocatore;

import java.util.List;

/**
 * Questa interfaccia rappresenta una gara di Formula 1, ovvero una partita del gioco
 */
public interface IGara {

    /**
     * Restituisce il circuito della gara.
     */
    ICircuito getCircuito();

    /**
     * Restituisce i giocatori che partecipano alla gara.
     */
    List<IGiocatore> getGiocatori();

    /**
     * Avvia la gara con i giocatori specificati.
     */
    void avviaGara();

    /**
     * Avanza la gara di un turno, facendo muovere tutti i giocatori.
     */
    void avanzaTurno();

    /**
     * Restituisce il giocatore vincitore della gara.
     */
    void vincitore();
}
