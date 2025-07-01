package org.java.milestone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {
    private String titolo;
    private List<Evento> eventi;

    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }

    public String getEventiInData(int giorno, int mese, int anno){
        
        LocalDate data = LocalDate.of(anno, mese, giorno);
        String datFormattata = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        List<Evento> eventiInData = new ArrayList<>();

        for (Evento evento : eventi) {
            if (evento.getData().equals(datFormattata)){
                eventiInData.add(evento);
            }
        }

        if (eventiInData.size() < 1){
            throw new IllegalArgumentException("Non ci sono eventi per questa data");
        } else {
            return (eventiInData.toString());
        }
    }

    public String numeroEventi() {
        if (eventi.size() > 0) {
            return "Ci sono " + eventi.size() + " in programma";
        } else {
            return "Non ci sono eventi in programma";
        }
    }

    public void svuotaEventi() {
        eventi.clear();
    }

    public String eventiOrdinati() {
        eventi.sort(Comparator.comparing()
    }
}
