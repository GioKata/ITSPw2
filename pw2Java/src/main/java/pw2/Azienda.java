package pw2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Azienda {
    private String nome;
    private ArrayList<Dipendente>  dipendenti;

    public Azienda(String nome){
        this.nome=nome;
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

    public void calcolaStipendio(){
        for (Dipendente d : dipendenti) {
            if(d.getClass()==Manager.class){
                calcolaStipendioM(d);
            }
        }
        for (Dipendente d : dipendenti) {
            if(d.getClass()==Dirigente.class){
                calcolaStipendioD(d);
            }
        }
         
    }
    public void calcolaStipendioM(Dipendente d){
        Manager m=(Manager) d;
        double c=0;
        for (Dipendente dip : dipendenti) {
            if(dip.getClass()==Tecnico.class){
                Tecnico t=(Tecnico) dip;
                if(t.getCodiceM().equals(m.cf)){
                    c=c+(t.getStipendio()*10/100);
                }
            }
        }
    }

    public void calcolaStipendioD(Dipendente d){
        Dirigente di=(Dirigente) d;
        double c=0;
        for (Dipendente dip : dipendenti) {
            if(!(dip.getClass()==Dirigente.class)){
                //calcola
                c=c+(dip.getStipendio()*10/100);
            }
        }
    }
    public void stampaScelta(String tipDipendente){
        sortPermanenza();
        switch (tipDipendente) {
            case "Manager":
                
                break;
            case "Dirigente":
                
            break;
            case "Tecnico":
                
                break;
        }
    }

    public void sortAlfabetico(){
        Collections.sort(dipendenti);
    }
    public void sortPermanenza() {
        Collections.sort(dipendenti, new Comparator<Dipendente>() {
            @Override
            public int compare(Dipendente d1, Dipendente d2) {
                return d1.getDataAssunzione().compareTo(d2.getDataAssunzione());
            }
        });
    }
    @Override
    public String toString() {
        return "Azienda [nome=" + nome + ", dipendenti=" + dipendenti + "]";
    }
}
