package org.java.milestone;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento{
    private LocalTime ora;
    private BigDecimal prezzo;


public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, BigDecimal prezzo) {
    super(titolo, data, postiTotali);
    this.ora = ora;
    this.prezzo = prezzo;
}

public LocalTime getOra() {
    return ora;
}

public void setOra(LocalTime ora){
    if (ora.isBefore(LocalTime.now())) {
        throw new IllegalArgumentException("L'ora selezionata e gia passata");
    } else {
        this.ora = ora;
    }
}

public BigDecimal getPrezzo() {
    return prezzo; 
}

public void setPrezzo (BigDecimal prezzo) {
    this.prezzo = prezzo;
}

public String getDataOra() {
    DateTimeFormatter oraFormattata = DateTimeFormatter.ofPattern("HH:mm");
    return getData() + " " + ora.format(oraFormattata);
}

public String getPrezzoFormattato() {
    NumberFormat formato = NumberFormat.getCurrencyInstance(Locale.ITALY);
    return formato.format(prezzo);
}


@Override
public String toString() {
    return getDataOra() + "-" + getTitolo() + "-" + getPrezzoFormattato();
}
}