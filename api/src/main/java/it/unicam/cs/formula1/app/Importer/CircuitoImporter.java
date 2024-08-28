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

package it.unicam.cs.formula1.app.Importer;

import it.unicam.cs.formula1.app.Circuito.Circuito;
import it.unicam.cs.formula1.app.Circuito.ICircuito;
import it.unicam.cs.formula1.app.Posizione.IPosizione;
import it.unicam.cs.formula1.app.Posizione.Posizione;

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
                if (!line.isEmpty()) {
                    gestisciRiga(line, posizioni, startLine, finishLine);
                }
            }
        }
        return new Circuito(posizioni, startLine, finishLine);
    }

    /**
     * Gestisce una riga del file e aggiorna i set di posizioni.
     *
     * @param line         La riga del file da gestire
     * @param posizioni    Set di posizioni generali
     * @param startLine    Set di posizioni di partenza
     * @param finishLine   Set di posizioni di arrivo
     */
    private static void gestisciRiga(String line, Set<IPosizione> posizioni,
                                     Set<IPosizione> startLine, Set<IPosizione> finishLine) {
        try {
            String[] parts = line.split(":");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Formato di riga non valido: " + line);
            }

            char tipo = parts[0].charAt(0);
            IPosizione posizione = convertiInPosizione(parts[1]);
            aggiornaSetDiPosizioni(tipo, posizione, posizioni, startLine, finishLine);
        } catch (Exception e) {
            throw new IllegalArgumentException("Errore nella gestione della riga: " + line, e);
        }
    }

    /**
     * Crea un oggetto Posizione a partire da una stringa di coordinate.
     *
     * @param posizioneStr La stringa contenente le coordinate
     * @return un oggetto IPosizione creato dalle coordinate
     */
    private static IPosizione convertiInPosizione(String posizioneStr) {
        String[] coords = posizioneStr.split(",");
        if (coords.length != 2) {
            throw new IllegalArgumentException("Formato di posizione non valido: " + posizioneStr);
        }

        int x = Integer.parseInt(coords[0].trim());
        int y = Integer.parseInt(coords[1].trim());
        return new Posizione(x, y);
    }

    /**
     * Aggiorna i set di posizioni in base al tipo di posizione.
     *
     * @param tipo         Il tipo di posizione ('N', 'S', 'E')
     * @param posizione    L'oggetto IPosizione da aggiungere
     * @param posizioni    Set di posizioni generali
     * @param startLine    Set di posizioni di partenza
     * @param finishLine   Set di posizioni di arrivo
     */
    private static void aggiornaSetDiPosizioni(char tipo, IPosizione posizione,
                                               Set<IPosizione> posizioni, Set<IPosizione> startLine,
                                               Set<IPosizione> finishLine) {
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
