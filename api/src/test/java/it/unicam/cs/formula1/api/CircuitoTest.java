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

package it.unicam.cs.formula1.api;

import it.unicam.cs.formula1.api.circuito.Circuito;
import it.unicam.cs.formula1.api.posizione.IPosizione;
import it.unicam.cs.formula1.api.posizione.Posizione2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test di unità per la classe Circuito.
 */
public class CircuitoTest {

    private Circuito circuito;
    private Set<IPosizione> posizioni;
    private Set<IPosizione> startLine;
    private Set<IPosizione> finishLine;

    private IPosizione posizioneDentro;
    private IPosizione posizioneFuori;

    @BeforeEach
    void setUp() {
        posizioni = new HashSet<>();
        startLine = new HashSet<>();
        finishLine = new HashSet<>();

        // Creo delle posizioni di test
        posizioneDentro = new Posizione2D(1, 2);
        posizioneFuori = new Posizione2D(3, 4);

        // Configurazione del circuito con delle posizioni di test
        posizioni.add(posizioneDentro);
        startLine.add(posizioneDentro);
        finishLine.add(posizioneDentro);

        circuito = new Circuito(posizioni, startLine, finishLine);
    }

    @Test
    void testIsInsideCircuit() {
        // Verifica che posizioneDentro sia all'interno del circuito
        assertTrue(circuito.isInsideCircuit(posizioneDentro));
        // Verifica che posizioneFuori non sia all'interno del circuito
        assertFalse(circuito.isInsideCircuit(posizioneFuori));
    }

    @Test
    void testIsInsideStartLine() {
        // Verifica che posizioneDentro sia all'interno della linea di partenza
        assertTrue(circuito.isInsideStartLine(posizioneDentro));
        // Verifica che posizioneFuori non sia all'interno della linea di partenza
        assertFalse(circuito.isInsideStartLine(posizioneFuori));
    }

    @Test
    void testIsInsideEndLine() {
        // Verifica che posizioneDentro sia all'interno della linea di arrivo
        assertTrue(circuito.isInsideEndLine(posizioneDentro));
        // Verifica che posizioneFuori non sia all'interno della linea di arrivo
        assertFalse(circuito.isInsideEndLine(posizioneFuori));
    }

    @Test
    void testGetStartLine() {
        // Verifica che il set della linea di partenza contenga esattamente posizioneDentro
        Set<IPosizione> startLineResult = circuito.getStartLine();
        assertEquals(1, startLineResult.size());
        assertTrue(startLineResult.contains(posizioneDentro));
    }

    @Test
    void testGetEndLine() {
        // Verifica che il set della linea di arrivo contenga esattamente posizioneDentro
        Set<IPosizione> finishLineResult = circuito.getEndLine();
        assertEquals(1, finishLineResult.size());
        assertTrue(finishLineResult.contains(posizioneDentro));
    }

    @Test
    void testGetAllPositions() {
        // Verifica che il set di tutte le posizioni contenga esattamente posizioneDentro
        Set<IPosizione> allPositionsResult = circuito.getAllPositions();
        assertEquals(1, allPositionsResult.size());
        assertTrue(allPositionsResult.contains(posizioneDentro));
    }
}