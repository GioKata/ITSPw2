package pw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pw2.Adapter;

public class App 
{
    public static void main( String[] args )
    {   
        String scelta,tip,r,r2;
        Scanner input=new Scanner(System.in);
        System.out.println("Scegli il nome dell'azienda");
        Azienda a=new Azienda(input.nextLine());
        createDaFile(a);
        do{//menu iterativo 'yes' per continuare
            System.out.println("Menù");
            do{//controllo valore input
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
                    do{//menu iterativo 'yes' per continuare
                        do{//controllo valore input
                            System.out.println("inserisci la tipologia di Dipendente di cui vuoi sapere i dati anagrafici (Tecnico,Manager,Dirigente)");
                            tip=input.nextLine();
                        }while(!tip.equalsIgnoreCase("Tecnico") && !tip.equalsIgnoreCase("Manager")  && !tip.equalsIgnoreCase("Dirigente"));
                        a.stampaScelta(tip);
                        do{//controllo valore input
                            System.out.println("Voui continuare a scegliere  una tipologia di Dipendente y/n");
                            r=input.nextLine();
                        }while(!r.equalsIgnoreCase("y") && !r.equalsIgnoreCase("yes") && !r.equalsIgnoreCase("n") && !r.equalsIgnoreCase("no"));
                    }while(r.equals("y") && !r.equalsIgnoreCase("yes"));
                    break;
            }
            do{//controllo valore input
                System.out.println("Sei tornato nel menù voui continuare y/n");
                r2=input.nextLine();
            }while(!r2.equalsIgnoreCase("y") && !r2.equalsIgnoreCase("yes") && !r2.equalsIgnoreCase("n") && !r2.equalsIgnoreCase("no")); 

        }while(r2.equals("y") && !r2.equalsIgnoreCase("yes"));
        input.close();
    }
    public static void createDaFile(Azienda a){
        int countLine=0;
        try (Scanner r = new Scanner(new File("elenco dipendenti.txt"))) {
            while(r.hasNextLine()){//ciclo per ogni riga del file
                countLine++;
                String[] s=r.nextLine().split(";");
                switch (s[0]) {//creo un dipendente in base al primo parametro
                    case "dirigente":
                        Dirigente d=new Dirigente(s[1], s[2], s[3], LocalDate.parse(s[4]), s[5]);
                        try {//eccezione lanciata in caso dipendente già inserito
                            a.addDipendente(d);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Errore nel file in riga:"+countLine+" dipendente già inserito cf:"+s[1]);
                        }
                        break;
                    case "manager":
                        Manager m=new Manager(s[1], s[2], s[3], LocalDate.parse(s[4]), s[6], s[5]);
                        try {
                            a.addDipendente(m);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Errore nel file in riga:"+countLine+" dipendente già inserito cf:"+s[1]);
                        }
                        break;
                    case "tecnico":
                        Tecnico t=new Tecnico(s[1], s[2], s[3], LocalDate.parse(s[4]),s[6],s[5]);
                        try {
                            a.addDipendente(t);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Errore nel file in riga:"+countLine+" dipendente già inserito cf:"+s[1]);
                        }
                        break;
                }
            }
            a.calcolaStipendio();
            r.close();
            FileJson(a.getDipendenti());
        }catch (FileNotFoundException e) {
            throw new RuntimeException("file elenco dipendenti.txt non trovato");
        }
    
    }
    public static void FileJson(ArrayList<Dipendente> d){       
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new Adapter()).create();
        String json = gson.toJson(d);
        File file;
        try {
            file = new File("Dipendenti.json");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(json.toString());
            fileWriter.close();
        } catch (Exception e) {
            
            System.out.println("file Dipendenti.json non trovato");
        }
    }
}
