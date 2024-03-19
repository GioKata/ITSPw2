package pw2;

import java.time.LocalDate;

public class Manager extends Dipendente{
    private String codiceD;
    private String settore;

    public Manager(String n, String c, LocalDate d,String settore,String codiceD) {
        super(n, c, d);
        this.codiceD=codiceD;
        stipendio=2000;
        this.settore = settore;
    }
    public  void setStipendio(int nTecnici){
        stipendio=stipendio+(nTecnici/10);
    }
    
}
