package pw2;

import java.time.LocalDate;

public class Dipendente {
    protected String nome;
    protected String cognome;
    protected LocalDate  dataAssunzione;
    protected double stipendio;

    public  Dipendente(String n, String c, LocalDate d, double s){
        nome=n;
        cognome=c;
        dataAssunzione=d;
        stipendio=s;
    }
    //costruttore senza definire stipendio
    public  Dipendente(String n, String c, LocalDate d){
        nome=n;
        cognome=c;
        dataAssunzione=d;
    }
}
