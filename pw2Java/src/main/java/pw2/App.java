package pw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {      
        String tip,r;
        Azienda a=new Azienda("Erreci");
        Scanner input=new Scanner(System.in);
        createDaFile(a);
        System.out.println("////////////////////STIPENDIO///////////////////");
        a.stampaStipendio();
        System.out.println("////////////////////ALFABETICO///////////////////");
        a.sortAlfabetico();
        System.out.println(a);
        /*Ciclo tipologia dip ordine permanenza */
        do{
            do{
                System.out.println("inserisci la tipologia di Dipendente di cui vuoi saperer i dati anagrafici");
                tip=input.nextLine();
            }while(!tip.equalsIgnoreCase("Tecnico") && !tip.equalsIgnoreCase("Manager")  && !tip.equalsIgnoreCase("Dirigente"));
            a.stampaScelta(tip);
            do{
                System.out.println("Voui continuare y/n");
                r=input.nextLine();
            }while(!r.equalsIgnoreCase("y") && !r.equalsIgnoreCase("yes") && !r.equalsIgnoreCase("n") && !r.equalsIgnoreCase("no"));
        }while(r.equals("y") && !r.equalsIgnoreCase("yes"));
        input.close();
    }
    public static void createDaFile(Azienda a){
        try (Scanner r = new Scanner(new File("pw2Java\\elenco dipendenti.txt"))) {
            while(r.hasNextLine()){
                String[] s=r.nextLine().split(";");
                switch (s[0]) {
                    case "dirigente":
                        Dirigente d=new Dirigente(s[1], s[2], s[3], LocalDate.parse(s[4]), s[5]);
                        a.addDipendente(d);
                        break;
                    case "manager":
                        Manager m=new Manager(s[1], s[2], s[3], LocalDate.parse(s[4]), s[6], s[5]);
                        a.addDipendente(m);
                        break;
                    case "tecnico":
                        Tecnico t=new Tecnico(s[1], s[2], s[3], LocalDate.parse(s[4]),s[6],s[5]);
                        a.addDipendente(t);
                        break;
                }
            }
            a.calcolaStipendio();
            r.close();
        }catch (FileNotFoundException e) {
            throw new RuntimeException("file non trovato");
        }
    
    }
}
