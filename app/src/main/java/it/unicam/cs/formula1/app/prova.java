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

package it.unicam.cs.formula1.app;

import it.unicam.cs.formula1.api.Circuito.ICircuito;
import it.unicam.cs.formula1.api.Importer.CircuitoImporter;
import it.unicam.cs.formula1.api.Visualizzatore.IVisualizzaCircuito;
import it.unicam.cs.formula1.api.Visualizzatore.VisualizzaCircuito;

import java.io.IOException;

public class prova {
    public static void main(String[] args) {
        try {
            CircuitoImporter importer = new CircuitoImporter();
            ICircuito circuito = importer.importaCircuito("src/main/java/it/unicam/cs/formula1/app/circuito.txt");
            IVisualizzaCircuito visualization = new VisualizzaCircuito();
            visualization.visualizzaCircuito(circuito);
        } catch (IOException e) {
            System.err.println("Errore durante l'importazione del circuito: " + e.getMessage());
        }
    }
}
