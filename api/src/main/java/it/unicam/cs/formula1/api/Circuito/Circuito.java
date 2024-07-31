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
 * Questa classe rappresenta un circuito del gioco Formula 1.
 */
public class Circuito implements ICircuito{

    private final Set<IPosizione> posizioni;
    private final Set<IPosizione> startLine;
    private final Set<IPosizione> finishLine;

    /**
     * Costruttore che crea un nuovo circuito.
     *
     * @param posizioni  Un insieme di posizioni che costituiscono il circuito.
     * @param startLine  Un insieme di posizioni che costituiscono la linea di partenza del circuito.
     * @param finishLine Un insieme di posizioni che costituiscono la linea di arrivo del circuito.
     */
    public Circuito(Set<IPosizione> posizioni, Set<IPosizione> startLine, Set<IPosizione> finishLine) {
        this.posizioni = posizioni;
        this.startLine = startLine;
        this.finishLine = finishLine;
    }

    /**
     * Verifica se una data posizione è all'interno del circuito.
     *
     * @param posizione La posizione da verificare.
     * @return true se la posizione è all'interno del circuito, false altrimenti.
     */
    @Override
    public boolean isInsideCircuit(IPosizione posizione) {
        return posizioni.contains(posizione);
    }

    /**
     * Restituisce il punto di partenza del circuito.
     *
     * @return La posizione di partenza del circuito.
     */
    @Override
    public Set<IPosizione> getStartLine() {
        return startLine;
    }

    /**
     * Restituisce il punto di arrivo del circuito.
     *
     * @return La posizione di arrivo del circuito.
     */
    @Override
    public Set<IPosizione> getEndLine() {
        return finishLine;
    }

    /**
     * Restituisce tutte le posizioni che costituiscono il circuito.
     *
     * @return Un insieme di posizioni che costituiscono il circuito.
     */
    @Override
    public Set<IPosizione> getAllPositions() {
        return posizioni;
    }
}
