package org.java.milestone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;
    
    public Evento(String titolo, LocalDate data, int postiTotali) {

        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;

        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data selezionata e gia passata");
        } else {
            this.data = data;
        }
        if (postiTotali < 0) { 
            throw new IllegalArgumentException("Il numero dei posti deve essere maggiore di zero");
        } else {
            this.postiTotali = postiTotali;
        }

        this.postiPrenotati = 0; 
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo){
       if (titolo.equals("")){
        throw new IllegalArgumentException("Inserisci almeno un carattere");
       } else {
        this.titolo = titolo;
       }
    }


    public String getData() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return this.data.format(formatter);
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public int getPostiTotali(){
        return postiTotali;
    }

    public int getPostiPrenotati(){
        return postiPrenotati;
    }


    public void prenota(){
        if (data.isBefore(LocalDate.now())) {
            System.out.println("Imposibile prenotare, evento gia concluso");
        } else if (postiPrenotati >= postiTotali) {
            System.out.println("Non ci sono piu posti disponibili");
        } else {
            postiPrenotati++;
            System.out.println("Prenotazione avvenuta con successo");
        }
    }

    public void disdici(){
        if (data.isBefore(LocalDate.now())) {
            System.out.println("Imposibile disdire, evento gia concluso");
        } else if (postiPrenotati == 0) {
            System.out.println("Non ci sono prenotazioni da disdire");
        } else {
            postiPrenotati--;
            System.out.println("Abbiamo effettuata con successo la sua disdetta");
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatoData) + "-" + titolo;
    }
}
