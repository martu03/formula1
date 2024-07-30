
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

import java.util.Objects;

public class Posizione implements IPosizione{
    private int x;
    private int y;

    /**
     * Costruttore che crea una posizione.
     *
     * @param x Cordinata x del punto.
     * @param y Cordinata y del punto.
    */
    public Posizione(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Restituisce la coordinata X della posizione.
     *
     * @return la coordinata X.
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Restituisce la coordinata Y della posizione.
     *
     * @return la coordinata Y.
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Confronta l'oggetto corrente con il parametro per verificare se sono uguali.
     * Due oggetti Posizione sono considerati uguali se hanno le stesse coordinate x e y.
     *
     * @param o l'oggetto da confrontare con l'oggetto corrente.
     * @return true se gli oggetti sono uguali, false altrimenti.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posizione posizione = (Posizione) o;
        return x == posizione.x && y == posizione.y;
    }

    /**
     * Restituisce un valore hash per l'oggetto Posizione.
     * Questo valore hash è calcolato usando le coordinate x e y.
     *
     * @return il valore hash dell'oggetto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Restituisce una rappresentazione stringa dell'oggetto Posizione.
     * La stringa include le coordinate x e y.
     *
     * @return una stringa che rappresenta l'oggetto Posizione.
     */
    @Override
    public String toString() {
        return "Posizione{" + "x=" + x + ", y=" + y + '}';
    }
}