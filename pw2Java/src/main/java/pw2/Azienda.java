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
            else{
                throw  new Exception();
            }
        } catch (Exception e) {
            System.out.println("Errore dipendente non inserito poichè già esistente:"+d.getCf());
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
        m.setStipendio(c);
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
        di.setStipendio(c);
    }
    public void stampaStipendio(){
        for (Dipendente d : dipendenti) {
            System.out.println(d.getClass().getSimpleName()+"[CF:"+d.getCf()+", nome:"+d.getNome()+", cognome:"+d.getCognome()+", stipendio:"+d.getStipendio()+"]");
        }
    }
    public void stampaScelta(String tipDipendente){
        sortPermanenza();
        for (Dipendente d : dipendenti) {
            if(d.getClass().getSimpleName().equalsIgnoreCase(tipDipendente)){
                stampaAnagrafici(d);
            }
        }
    }

    public void sortPermanenza() {
        Collections.sort(dipendenti, new Comparator<Dipendente>() {
            @Override
            public int compare(Dipendente d1, Dipendente d2) {
                return d1.getDataAssunzione().compareTo(d2.getDataAssunzione());
            }
        });
    }
    public void  stampaAnagrafici(Dipendente d){
        System.out.println(d.getClass().getSimpleName()+"[Nome:"+d.getNome()+", Cognome:"+d.getCognome()+", cf:"+d.getCf()+"]");
    }

    public void sortAlfabetico(){
        Collections.sort(dipendenti);
    }

    @Override
    public String toString() {
        return "Azienda [nome=" + nome + ", dipendenti=" + dipendenti + "]";
    }
}
