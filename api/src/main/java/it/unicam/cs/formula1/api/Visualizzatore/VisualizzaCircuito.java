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

package it.unicam.cs.formula1.api.Visualizzatore;

import it.unicam.cs.formula1.api.Circuito.ICircuito;
import it.unicam.cs.formula1.api.Posizione.IPosizione;
import it.unicam.cs.formula1.api.Posizione.Posizione;

/**
 * Classe che rappresenta un visualizzatore di circuiti.
 */
public class VisualizzaCircuito implements IVisualizzaCircuito{
    /**
     * Visualizza un circuito.
     *
     * @param circuito il circuito da visualizzare
     */
    @Override
    public void visualizzaCircuito(ICircuito circuito) {
        int maxX = circuito.getAllPositions().stream().mapToInt(IPosizione::getX).max().orElse(0);
        int maxY = circuito.getAllPositions().stream().mapToInt(IPosizione::getY).max().orElse(0);

        for (int y = 0; y <= maxY; y++) {
            for (int x = 0; x <= maxX; x++) {
                IPosizione posizione = new Posizione(x, y);

                if (circuito.getStartLine().contains(posizione)) {
                    System.out.print("S");
                } else if (circuito.getEndLine().contains(posizione)) {
                    System.out.print("E");
                } else if (circuito.getAllPositions().contains(posizione)) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
}
