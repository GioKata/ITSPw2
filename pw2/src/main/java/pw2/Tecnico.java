package pw2;

import java.time.LocalDate;

public class Tecnico extends Dipendente{
    private String specialita;
    private String codiceM;

    public Tecnico(String nome,String cognome,LocalDate data,String specialita, String codiceM){
        super(nome,cognome,data);
        this.codiceM=codiceM;
        this.specialita = specialita;
        if(data.plusYears(10).isBefore(LocalDate.now())){
            this.stipendio=1600;
        }else{
            stipendio=1500;
        }
    }
}