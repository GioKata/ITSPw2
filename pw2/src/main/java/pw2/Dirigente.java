package pw2;

import java.time.LocalDate;

public class Dirigente extends Dipendente{
    private String divisione;


    public Dirigente(String n, String c, LocalDate d) {
        super(n, c, d);
        stipendio=2500;
        
    }
    //da sistemare
    public  void setStipendio(int nPersonale){
        stipendio=stipendio+(nPersonale/10);
    }
}
