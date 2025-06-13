package org.java.milestone;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TestConcerto {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Inserisci il titolo del concerto: ");
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
            System.out.println("Inserisci il numero dei posti del concerto: ");
            try {
                postiTotali = Integer.parseInt(scanner.nextLine());
                if (postiTotali <= 0) {
                    System.out.println("Il numero dei posti totale deve essere un numero maggiore di 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Il numero inserito deve essere un numero intero");
            }
        }

        LocalTime ora = null;
        DateTimeFormatter formatoOra = DateTimeFormatter.ofPattern("HH:mm");

            System.out.println("Inserisci l'ora (HH:mm): ");
            String oraInput = scanner.nextLine();
            try {
                ora = LocalTime.parse(oraInput, formatoOra);
            } catch (DateTimeParseException e) {
                    System.out.println("Inserire l'ora nel formato sopraindicato");
                }
            

        BigDecimal prezzo = null;
        while (prezzo == null) {
            System.out.println("Inserisci il prezzo del biglietto (xx.xx): ");
            String prezzoInput = scanner.nextLine();
        try {
            BigDecimal prezzoFormattato = new BigDecimal(prezzoInput);
            if (prezzoFormattato.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("Il prezzo non puo essere minore di 0");
            } else {
                prezzo = prezzoFormattato;
            }
            }   catch (NumberFormatException e) {
                System.out.println("Inserire il prezzo nel formato sopraindicato");
            }
        }
        

        Concerto nuovoConcerto = new Concerto(titolo, data, postiTotali, ora, prezzo);

        System.out.println("Concerto creato! Vuoi effettuare una prenotazione per " + nuovoConcerto.toString() + "? [Si/No]");
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
            nuovoConcerto.prenota();
        }

        System.out.println("Posti prenotati: " + nuovoConcerto.getPostiPrenotati());
        System.out.println("Posti ancora disponibili: " + (nuovoConcerto.getPostiTotali() - nuovoConcerto.getPostiPrenotati()));
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
            nuovoConcerto.disdici();
        }
        System.out.println("Posti prenotati: " + nuovoConcerto.getPostiPrenotati());
        System.out.println("Posti ancora disponibili: " + (nuovoConcerto.getPostiTotali() - nuovoConcerto.getPostiPrenotati()));
    }

    scanner.close();
    }
}

