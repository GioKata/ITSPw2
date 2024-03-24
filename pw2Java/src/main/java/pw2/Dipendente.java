package pw2;

import java.time.LocalDate;

public class Dipendente implements Comparable<Dipendente>{
    protected String cf;
    protected String nome;
    protected String cognome;
    protected LocalDate  dataAssunzione;
    protected double stipendio;
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public LocalDate getDataAssunzione() {
        return dataAssunzione;
    }
    public String getCf() {
        return cf;
    }
    public double getStipendio() {
        return stipendio;
    }
    //costruttore senza definire stipendio
    public  Dipendente(String cf,String n, String c, LocalDate d){
        this.cf=cf;
        nome=n;
        cognome=c;
        dataAssunzione=d;
    }
    @Override
    public String toString() {
        return "Dipendente [nome=" + nome + ", cognome=" + cognome + ", dataAssunzione=" + dataAssunzione
                + ", stipendio=" + stipendio + "]";
    }
    @Override
    public int compareTo(Dipendente d) {
        if(this.cognome.compareTo(d.cognome)==0){
            return this.nome.compareTo(d.nome);
        }else{
            return this.cognome.compareTo(d.cognome);
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dipendente other = (Dipendente) obj;
        if (cf == null) {
            if (other.cf != null)
                return false;
        } else if (!cf.equals(other.cf))
            return false;
        return true;
    }
    
}
