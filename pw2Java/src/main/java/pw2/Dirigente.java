package pw2;

import java.time.LocalDate;

public class Dirigente extends Dipendente{
    private String divisione;

    public Dirigente(String cf,String n, String c, LocalDate d,String di) {
        super(cf,n, c, d);
        stipendio=2500;
        divisione=di;
    }
    //da sistemare
    public  void setStipendio(double somma){
        stipendio=stipendio+somma;
    }
}
