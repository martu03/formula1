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

package it.unicam.cs.formula1.api.strategia;

import it.unicam.cs.formula1.api.circuito.ICircuito;
import it.unicam.cs.formula1.api.giocatore.IGiocatore;
import it.unicam.cs.formula1.api.mossa.Mossa2D;
import it.unicam.cs.formula1.api.posizione.IPosizione;
import it.unicam.cs.formula1.api.posizione.Posizione2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe rappresenta una strategia di gioco che permette al veicolo di muoversi nel punto principale, nei
 * suoi 8 vicini o nei 8 vicini della posizione attuale.
 */
public class StrategiaPuntoPrincipale implements IStrategiaDiGioco{

    private Mossa2D ultimaMossa;

    public StrategiaPuntoPrincipale() {
        this.ultimaMossa = new Mossa2D(0, 0);
    }

    /**
     * Ritorna l'ultima mossa compiuta dal giocatore.
     *
     * @return l'ultima mossa compiuta dal giocatore.
     */
    public Mossa2D getUltimaMossa() {
        return ultimaMossa;
    }

    /**
     * Imposta l'ultima mossa compiuta dal giocatore.
     *
     * @param posizioneScelta posizione scelta dal giocatore.
     */
    public void setUltimaMossa(IPosizione posizioneScelta, IGiocatore giocatore) {
        int dx = posizioneScelta.getCoordinate()[0]  - giocatore.getPosizioneAttuale().getCoordinate()[0] ;
        int dy = posizioneScelta.getCoordinate()[1]  - giocatore.getPosizioneAttuale().getCoordinate()[1];

        List<Integer> coordinate = new ArrayList<>();
        coordinate.add(dx);
        coordinate.add(dy);
        this.ultimaMossa.setCoordinate(coordinate);
    }

    /**
     * Restituisce la lista delle posizioni in cui il veicolo può muoversi.
     *
     * @param giocatore il giocatore che sta giocando
     * @param circuito il circuito su cui si sta giocando
     * @param posizioniGiocatori la lista delle posizioni dei veicoli dei giocatori
     * @return la lista delle posizioni in cui il veicolo può muoversi
     */
    @Override
    public List<IPosizione> possibiliPosizioni(IGiocatore giocatore, ICircuito circuito, List<IPosizione> posizioniGiocatori) {
        IPosizione posizioneAttuale = giocatore.getPosizioneAttuale();
        IPosizione puntoPrincipale = this.calcolaPuntoPrincipale(giocatore, circuito);
        List<IPosizione> ottoVicini = new ArrayList<>();

        //controllo se devo calcolare gli otto vicini del punto principale o della posizione attuale
        if(circuito.isInsideCircuit(puntoPrincipale))
            ottoVicini = puntoPrincipale.Vicini();
        else
            ottoVicini = posizioneAttuale.Vicini();

        List<IPosizione> posizioniPossibili = new ArrayList<>();

        if(!puntoPrincipale.equals(posizioneAttuale)) {
            ottoVicini.add(puntoPrincipale);
            ottoVicini.remove(posizioneAttuale);
        }

        for (IPosizione posizione : ottoVicini) {
            if(circuito.isInsideCircuit(posizione) && !(posizioniGiocatori.contains(posizione)) ){
                posizioniPossibili.add(posizione);
            }
        }

        return posizioniPossibili;
    }

    /**
     * Calcola il punto principale in cui il veicolo può muoversi.
     *
     * @param giocatore il giocatore che sta giocando
     * @param circuito il circuito su cui si sta giocando
     * @return il punto principale in cui il veicolo può muoversi
     */
    private IPosizione calcolaPuntoPrincipale(IGiocatore giocatore, ICircuito circuito) {
        int x = giocatore.getPosizioneAttuale().getCoordinate()[0] + this.getUltimaMossa().getCoordinate().get(0);
        int y = giocatore.getPosizioneAttuale().getCoordinate()[1] + this.getUltimaMossa().getCoordinate().get(1);

        return new Posizione2D(x, y);
    }
}
