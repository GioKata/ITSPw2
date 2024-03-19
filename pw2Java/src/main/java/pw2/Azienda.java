package pw2;

import java.util.ArrayList;

public class Azienda {
    private ArrayList<Dipendente>  dipendenti;
    public Azienda(){
        this.dipendenti=new ArrayList<>();
    }
    public void addDipendente(Dipendente d){
        try {
            if(!dipendenti.contains(d))
                dipendenti.add(d);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Errore:");
        }
    }
}
