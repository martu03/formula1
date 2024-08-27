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

package it.unicam.cs.formula1.app.Giocatori;

/**
 * Questa classe rappresenta una mossa di un giocatore.
 */
public class Mossa {
    private int dx; // Spostamento destra-sinistra
    private int dy; // Spostamento alto-basso

    /**
     * Costruttore che crea una mossa.
     *
     * @param dx Spostamento destra-sinistra.
     * @param dy Spostamento alto-basso.
     */
    public Mossa(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Restituisce lo spostamento destra-sinistra.
     *
     * @return lo spostamento destra-sinistra.
     */
    public int getDx() {
        return this.dx;
    }

    /**
     * Restituisce lo spostamento alto-basso.
     *
     * @return lo spostamento alto-basso.
     */
    public int getDy() {
        return this.dy;
    }

    /**
     * Imposta lo spostamento destra-sinistra e alto-basso.
     *
     * @param dx Spostamento destra-sinistra.
     * @param dy Spostamento alto-basso.
     */
    public void setMossa(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Restituisce una rappresentazione stringa dell'oggetto Mossa.
     * La stringa include le coordinate dx e dy.
     *
     * @return una stringa che rappresenta l'oggetto Mossa.
     */
    @Override
    public String toString() {
        return "Mossa(" + dx + ", " + dy + ")";
    }
}
