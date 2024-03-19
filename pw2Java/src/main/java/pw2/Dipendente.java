package pw2;

import java.time.LocalDate;

public class Dipendente implements Comparable<Dipendente>{
    protected String cf;
    protected String nome;
    protected String cognome;
    protected LocalDate  dataAssunzione;
    protected double stipendio;
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
    public int compareTo(Dipendente o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
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