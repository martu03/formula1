
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
package it.unicam.cs.formula1.api.Circuito;

import it.unicam.cs.formula1.api.Posizione.IPosizione;

import java.util.Set;

/**
 * Questa interfaccia rappresenta un circuito del gioco Formula 1.
 */
public interface ICircuito {

    /**
     * Verifica se una data posizione è all'interno del circuito.
     *
     * @param posizione La posizione da verificare.
     * @return true se la posizione è all'interno del circuito, false altrimenti.
     */
    boolean isInsideCircuit(IPosizione posizione);

    /**
     * Verifica se una data posizione è all'interno della linea di partenza.
     *
     * @param posizione La posizione da verificare.
     * @return true se la posizione è all'interno della linea di partenza, false altrimenti.
     */
    boolean isInsideStartLine (IPosizione posizione);

    /**
     * Verifica se una data posizione è all'interno della linea di arrivo.
     *
     * @param posizione La posizione da verificare.
     * @return true se la posizione è all'interno della linea di arrivo, false altrimenti.
     */
    boolean isInsideEndLine (IPosizione posizione);

    /**
     * Restituisce i punti di partenza del circuito.
     *
     * @return Le posizioni di partenza del circuito.
     */
    Set<IPosizione> getStartLine();

    /**
     * Restituisce i punti di arrivo del circuito.
     *
     * @return Le posizioni di arrivo del circuito.
     */
    Set<IPosizione> getEndLine();

    /**
     * Restituisce tutte le posizioni che costituiscono il circuito.
     *
     * @return Un insieme di posizioni che costituiscono il circuito.
     */
    Set<IPosizione> getAllPositions();
}
