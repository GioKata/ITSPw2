package pw2;

import java.time.LocalDate;

public class Tecnico extends Dipendente{
    private String specialita;
    private String codiceM;

    public String getCodiceM() {
        return codiceM;
    }

    public Tecnico(String cf,String nome,String cognome,LocalDate data,String specialita, String codiceM){
        super(cf,nome,cognome,data);
        this.codiceM=codiceM;
        this.specialita = specialita;
        if(data.plusYears(10).isBefore(LocalDate.now())){
            this.stipendio=1600;
        }else{
            stipendio=1500;
        }
    }

    @Override
    public String toString() {
        return super.toString() +", specialita="+ specialita + ", codiceM=" + codiceM + "]";
    }
    
}