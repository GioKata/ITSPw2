package pw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {   
        String scelta,tip,r,r2;
        Scanner input=new Scanner(System.in);
        System.out.println("Scegli il nome dell'azienda");
        Azienda a=new Azienda(input.nextLine());
        createDaFile(a);
        do{
            System.out.println("Menù");
            do{
                System.out.println("1)Stipendio  2)Ordine Alfabetico  3)Tipologia");
                scelta=input.nextLine();
            }while(!scelta.equalsIgnoreCase("Stipendio") && !scelta.equalsIgnoreCase("1") && !scelta.equalsIgnoreCase("Ordine Alfabetico") && !scelta.equalsIgnoreCase("2") && !scelta.equalsIgnoreCase("Tipologia") && !scelta.equalsIgnoreCase("3"));
            switch(scelta){
                case "Stipendio": case "1":
                    System.out.println("////////////////////STIPENDIO///////////////////");
                    a.stampaStipendio();
                    break;
                case "Ordine Alfabetico": case "2":
                    System.out.println("////////////////////ALFABETICO///////////////////");
                    a.sortAlfabetico();
                    System.out.println(a);
                    break;
                case  "Tipologia": case "3":
                    do{
                        do{
                            System.out.println("inserisci la tipologia di Dipendente di cui vuoi sapere i dati anagrafici (Tecnico,Manager,Dirigente)");
                            tip=input.nextLine();
                        }while(!tip.equalsIgnoreCase("Tecnico") && !tip.equalsIgnoreCase("Manager")  && !tip.equalsIgnoreCase("Dirigente"));
                        a.stampaScelta(tip);
                        do{
                            System.out.println("Voui continuare a scegliere  una tipologia di Dipendente y/n");
                            r=input.nextLine();
                        }while(!r.equalsIgnoreCase("y") && !r.equalsIgnoreCase("yes") && !r.equalsIgnoreCase("n") && !r.equalsIgnoreCase("no"));
                    }while(r.equals("y") && !r.equalsIgnoreCase("yes"));
                    break;
            }
            do{
                System.out.println("Sei tornato nel menù voui continuare y/n");
                r2=input.nextLine();
            }while(!r2.equalsIgnoreCase("y") && !r2.equalsIgnoreCase("yes") && !r2.equalsIgnoreCase("n") && !r2.equalsIgnoreCase("no")); 

        }while(r2.equals("y") && !r2.equalsIgnoreCase("yes"));
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
