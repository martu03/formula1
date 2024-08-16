
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
package it.unicam.cs.formula1.api.Posizione;

/**
 * Questa interfaccia rappresenta il concetto di posizione, componente
 * del circuito di Formula 1.
 */
public interface IPosizione {

    /**
     * Restituisce la coordinata X della posizione.
     *
     * @return la coordinata X.
     */
    int getX();

    /**
     * Restituisce la coordinata Y della posizione.
     *
     * @return la coordinata Y.
     */
    int getY();

    /**
     * Restituisce un array di 8 posizioni che rappresentano i vicini della posizione.
     *
     * @return un array di 8 posizioni.
     */
    public IPosizione[] getOttoVicini();

    /**
     * Imposta la coordinata X della posizione.
     *
     * @param x La coordinata X.
     */
    void setX(int x);

    /**
     * Imposta la coordinata Y della posizione.
     *
     * @param y La coordinata Y.
     */
    void setY(int y);
}
