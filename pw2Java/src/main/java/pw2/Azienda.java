package pw2;

import java.util.ArrayList;

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
                    c=c+(t.stipendio*10/100);
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
                c=c+(dip.stipendio*10/100);
            }
        }
    }

    @Override
    public String toString() {
        return "Azienda [nome=" + nome + ", dipendenti=" + dipendenti + "]";
    }
}
