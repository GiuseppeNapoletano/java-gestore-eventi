package org.java.milestone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Inserisci il titolo dell'evento: ");
        String titolo;
        while (true) {
            titolo = scanner.nextLine();
            
            if (titolo.equals("")) {
                System.out.println("Inserisci almeno un carattere");
            } else {
                break;
            }
        }

        LocalDate data = null;
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (data == null) {
            System.out.println("Inserisci la data (dd/mm/yyyy): ");
            String dataInput = scanner.nextLine();
            try {
                LocalDate dataFormattata = LocalDate.parse(dataInput, formatoData);
                if (dataFormattata.isBefore(LocalDate.now())) {
                    System.out.println("Inserisci una data non passata");
                } else {
                    data = dataFormattata;
                } 
            } catch (DateTimeParseException e) {
                    System.out.println("Inserire la data nel formato sopraindicato");
                }
            }

        int postiTotali = 0;
        while (postiTotali <= 0) {
            System.out.println("Inserisci il numero dei posti dell'evento: ");
            try {
                postiTotali = Integer.parseInt(scanner.nextLine());
                if (postiTotali <= 0) {
                    System.out.println("Il numero dei posti totale deve essere un numero maggiore di 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Il numero inserito deve essere un numero intero");
            }
        }

        Evento nuovoEvento = new Evento(titolo, data, postiTotali);

        System.out.println("Evento creato! Vuoi effettuare una prenotazione per " + nuovoEvento.toString() + "? [Si/No]");
        String rispostaPrenotazione;

        while (true) {
            rispostaPrenotazione = scanner.nextLine().toLowerCase();
                
            if (rispostaPrenotazione.equals("si") || rispostaPrenotazione.equals("no")) {
                break;
            } else {
                System.out.println("Inserisci una risposta tra: [Si/No]");
            }
        }

        int postiPrenotati = 0;

        if (rispostaPrenotazione.equalsIgnoreCase("si")) {
            System.out.println("Quanti posti intendi prenotare?");
            try {
            int prenotazioni = Integer.parseInt(scanner.nextLine());
            if (prenotazioni < 0) {
                System.out.println("Il numero inserito deve essere un numero non negativo");
            } else {
                postiPrenotati = prenotazioni;
            } 
        } catch (NumberFormatException e) {
                System.out.println("Il numero inserito deve essere un numero intero");
            }
        
        for (int i = 0; i < postiPrenotati; i++) {
            nuovoEvento.prenota();
        }

        System.out.println("Posti prenotati: " + nuovoEvento.getPostiPrenotati());
        System.out.println("Posti ancora disponibili: " + (nuovoEvento.getPostiTotali() - nuovoEvento.getPostiPrenotati()));
    }

    System.out.println("Vuoi disdire dei posti precedentemente prenotati? [Si/No]");
    String rispostaDisdetta;

        while (true) {
            rispostaDisdetta = scanner.nextLine().toLowerCase();
                
            if (rispostaDisdetta.equals("si") || rispostaDisdetta.equals("no")) {
                break;
            } else {
                System.out.println("Inserisci una risposta tra: [Si/No]");
            }
        }

    int postiDisdettati = 0;

        if (rispostaDisdetta.equalsIgnoreCase("si")) {
            System.out.println("Quanti posti intendi disdettare?");
            try {
            int disdette = Integer.parseInt(scanner.nextLine());
            if (disdette < 0) {
                System.out.println("Il numero inserito deve essere un numero non negativo");
            } else {
                postiDisdettati = disdette;
            } 
        } catch (NumberFormatException e) {
                System.out.println("Il numero inserito deve essere un numero intero");
            }

        for (int i = 0; i < postiDisdettati; i++) {
            nuovoEvento.disdici();
        }
        System.out.println("Posti prenotati: " + nuovoEvento.getPostiPrenotati());
        System.out.println("Posti ancora disponibili: " + (nuovoEvento.getPostiTotali() - nuovoEvento.getPostiPrenotati()));
    }

    scanner.close();
    }
}
