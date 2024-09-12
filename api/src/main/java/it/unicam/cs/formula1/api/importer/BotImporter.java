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

package it.unicam.cs.formula1.api.importer;

import it.unicam.cs.formula1.api.giocatore.GiocatoreBot;
import it.unicam.cs.formula1.api.giocatore.IGiocatore;
import it.unicam.cs.formula1.api.strategia.IStrategiaDiGioco;
import it.unicam.cs.formula1.api.strategia.StrategiaOttoVicini;
import it.unicam.cs.formula1.api.strategia.StrategiaPuntoPrincipale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe si occupa di importare i bot del gioco da un file.
 */
public class BotImporter {

    /**
     * Importa i bot del gioco da un file.
     *
     * @param nomeFile il nome del file da cui importare i bot
     * @return la lista dei bot importati
     * @throws IOException se si verifica un errore durante la lettura del file
     */
    public static List<IGiocatore> importaBot(String nomeFile) throws IOException {
        List<IGiocatore> giocatoriBot = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    IGiocatore giocatore = creaGiocatoreDaLinea(line);
                    if (giocatore != null) {
                        giocatoriBot.add(giocatore);
                    }
                }
            }
        }

        return giocatoriBot;
    }

    /**
     * Crea un giocatore a partire da una riga del file.
     * La riga deve essere nel formato "simbolo;strategia".
     *
     * @param line la riga del file contenente il simbolo e la strategia del giocatore
     * @return un'istanza di GiocatoreBot configurata secondo la riga, oppure null se la riga non è valida
     */
    private static IGiocatore creaGiocatoreDaLinea(String line) {
        String[] parts = line.split(";");
        char simbolo = 0;
        IStrategiaDiGioco strategia = null;
        if (parts.length == 2) {
            simbolo = parts[0].charAt(0);
            String strategiaNome = parts[1].trim();

            // Crea l'istanza della strategia
            strategia = creaStrategia(strategiaNome);

            if (strategia != null) {
                return new GiocatoreBot(simbolo, strategia);
            } else {
                System.err.println("Strategia non riconosciuta: " + strategiaNome);
            }
        } else {
            System.err.println("Formato della riga non valido: " + line);
        }

        return new GiocatoreBot(simbolo, strategia);
    }

    /**
     * Crea un'istanza della strategia basata sul nome della strategia.
     *
     * @param nomeStrategia il nome della strategia
     * @return un'istanza dell'interfaccia IStrategiaDiGioco, oppure null se la strategia non è riconosciuta
     */
    private static IStrategiaDiGioco creaStrategia(String nomeStrategia) {
        switch (nomeStrategia.toLowerCase()) {
            case "strategiaottovicini":
                return new StrategiaOttoVicini();

            case "strategiapuntoprincipale":
                return new StrategiaPuntoPrincipale();

            // Aggiungi ulteriori strategie qui se necessario
            default:
                System.err.println("Strategia non riconosciuta: " + nomeStrategia);
                return null;
        }
    }
}
