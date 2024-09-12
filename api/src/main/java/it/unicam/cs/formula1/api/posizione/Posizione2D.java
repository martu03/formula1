
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
package it.unicam.cs.formula1.api.posizione;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Questa classe rappresenta una posizione che compone il circuito del gioco.
 * Una posizione2D è definita da due coordinate x e y.
 */
public class Posizione2D implements IPosizione {
    private final int x;
    private final int y;

    /**
     * Costruttore che crea una posizione.
     *
     * @param x Cordinata x del punto.
     * @param y Cordinata y del punto.
    */
    public Posizione2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Restituisce un array di interi rappresentante le coordinate della posizione.
     *
     * @return un array di interi con le coordinate.
     */
    @Override
    public int[] getCoordinate() {
        return new int[]{x, y};
    }

    /**
     * Restituisce una lista di posizioni vicine alla posizione corrente.
     *
     * @return una lista di posizioni vicine.
     */
    @Override
    public List<IPosizione> Vicini(){
        int[] valori = {-1, 0, 1};
        List<IPosizione> ottoVicini = new ArrayList<>();
        int index = 0;

        for (int dx : valori) {
            for (int dy : valori) {
                if (dx != 0 || dy != 0) {  // Escludo la posizione centrale
                    ottoVicini.add(new Posizione2D(this.x + dx, this.y + dy));
                    index++;
                }
            }
        }
        return ottoVicini;
    }

    /**
     * Confronta l'oggetto corrente con il parametro per verificare se sono uguali.
     * Due oggetti Posizione2D sono considerati uguali se hanno le stesse coordinate x e y.
     *
     * @param o l'oggetto da confrontare con l'oggetto corrente.
     * @return true se gli oggetti sono uguali, false altrimenti.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posizione2D posizione = (Posizione2D) o;
        return x == posizione.x && y == posizione.y;
    }

    /**
     * Restituisce un valore hash per l'oggetto Posizione2D.
     * Questo valore hash è calcolato usando le coordinate x e y.
     *
     * @return il valore hash dell'oggetto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Restituisce una rappresentazione stringa dell'oggetto Posizione2D.
     * La stringa include le coordinate x e y.
     *
     * @return una stringa che rappresenta l'oggetto Posizione2D.
     */
    @Override
    public String toString() {
        return "Posizione2D{" + "x=" + x + ", y=" + y + '}';
    }


}
