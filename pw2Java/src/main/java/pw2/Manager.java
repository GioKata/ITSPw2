package pw2;

import java.time.LocalDate;

public class Manager extends Dipendente{
    private String codiceD;
    private String settore;

    public Manager(String cf,String n, String c, LocalDate d,String settore,String codiceD) {
        super(cf,n, c, d);
        this.codiceD=codiceD;
        stipendio=2000;
        this.settore = settore;
    }
    public  void setStipendio(double somma){
        stipendio=stipendio+somma;
    }
    @Override
    public String toString() {
        return super.toString()+", codiceD=" + codiceD + ", settore=" + settore + "]";
    }
    
}
