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

package it.unicam.cs.formula1.api.mossa;

import java.util.List;

/**
 * Questa classe rappresenta una mossa di un giocatore.
 */
public class Mossa2D implements IMossa {
    private int dx; // Spostamento destra-sinistra
    private int dy; // Spostamento alto-basso

    /**
     * Costruttore che crea una mossa.
     *
     * @param dx Spostamento destra-sinistra.
     * @param dy Spostamento alto-basso.
     */
    public Mossa2D(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Restituisce le coordinate della mossa.
     *
     * @return le coordinate della mossa.
     */
    @Override
    public List<Integer> getCoordinate() {
        return List.of(dx, dy);
    }

    /**
     * Imposta le coordinate della mossa.
     *
     * @param coordinate le coordinate della mossa.
     */
    @Override
    public void setCoordinate(List<Integer> coordinate) {
        this.dx = coordinate.get(0);
        this.dy = coordinate.get(1);
    }

    /**
     * Restituisce una rappresentazione stringa dell'oggetto Mossa2D.
     * La stringa include le coordinate dx e dy.
     *
     * @return una stringa che rappresenta l'oggetto Mossa2D.
     */
    @Override
    public String toString() {
        return "Mossa2D(" + dx + ", " + dy + ")";
    }
}
