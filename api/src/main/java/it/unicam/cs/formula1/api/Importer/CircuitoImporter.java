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

package it.unicam.cs.formula1.api.Importer;

import it.unicam.cs.formula1.api.Circuito.Circuito;
import it.unicam.cs.formula1.api.Circuito.ICircuito;
import it.unicam.cs.formula1.api.Posizione.IPosizione;
import it.unicam.cs.formula1.api.Posizione.Posizione;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe che rappresenta un importatore di circuiti.
 */
public class CircuitoImporter {
    /**
     * Importa un circuito da un file.
     *
     * @param nomeFile il nome del file da cui importare il circuito
     * @return il circuito importato
     */

    public static ICircuito importaCircuito(String nomeFile) throws IOException {
        Set<IPosizione> posizioni = new HashSet<>();
        Set<IPosizione> startLine = new HashSet<>();
        Set<IPosizione> finishLine = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                // Dividi la riga in tipo e coordinate
                String[] parts = line.split(":");
                if (parts.length != 2) {
                    throw new IllegalArgumentException("Formato di riga non valido: " + line);
                }

                char tipo = parts[0].charAt(0);
                String posizioneStr = parts[1];

                // Parse le coordinate
                String[] coords = posizioneStr.split(",");
                if (coords.length != 2) {
                    throw new IllegalArgumentException("Formato di posizione non valido: " + posizioneStr);
                }

                int x = Integer.parseInt(coords[0].trim());
                int y = Integer.parseInt(coords[1].trim());
                IPosizione posizione = new Posizione(x, y);

                // Aggiungi la posizione al set appropriato
                switch (tipo) {
                    case 'N':
                        posizioni.add(posizione);
                        break;
                    case 'S':
                        posizioni.add(posizione);
                        startLine.add(posizione);
                        break;
                    case 'E':
                        posizioni.add(posizione);
                        finishLine.add(posizione);
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo di posizione non valido: " + tipo);
                }
            }
        }
        return new Circuito(posizioni, startLine, finishLine);
    }
}
