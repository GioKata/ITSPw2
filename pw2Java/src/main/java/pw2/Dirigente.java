package pw2;

import java.time.LocalDate;

public class Dirigente extends Dipendente{
    private String divisione;
    private String codiceManager;


    public Dirigente(String cf,String n, String c, LocalDate d,String di,String co) {
        super(cf,n, c, d);
        stipendio=2500;
        divisione=di;
        codiceManager=co;
    }
    //da sistemare
    public  void setStipendio(int nPersonale){
        stipendio=stipendio+(nPersonale/10);
    }
}
