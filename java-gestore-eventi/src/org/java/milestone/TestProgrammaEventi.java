package org.java.milestone;

import java.time.LocalDate;

public class TestProgrammaEventi {
    public static void main(String[] args) {
        ProgrammaEventi progamma = new ProgrammaEventi("Test");
        Evento evento1 = new Evento("Evento 1", LocalDate.of(2025, 7, 1), 30);
        Evento evento2 = new Evento("Evento 2", LocalDate.of(2027, 1, 30), 50);
        Evento evento3 = new Evento("Evento 3", LocalDate.of(2030, 5, 15), 15);
        Evento evento4 = new Evento("Evento 4", LocalDate.of(2026, 10, 29), 30);


        progamma.aggiungiEvento(evento1);
        progamma.aggiungiEvento(evento2);
        progamma.aggiungiEvento(evento3);
        progamma.aggiungiEvento(evento4);

        System.out.println("---EVENTI IN DATA SCELTA---");
        System.out.println(progamma.getEventiInData(1, 7, 2025));

        System.out.println("---EVENTI IN PROGRAMMA---");
        System.out.println("Numero eventi: " + progamma.numeroEventi());

        System.out.println("---EVENTI ORDINATI PER DATA---");
        
        

        System.out.println("---ELIMINAZIONE EVENTI---");
        progamma.svuotaEventi();
        System.out.println("Numero eventi: " + progamma.numeroEventi());
    }
}
