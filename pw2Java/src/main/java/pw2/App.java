package pw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   
        Azienda a=new Azienda("Erreci");
        Scanner input=new Scanner(System.in);
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
                
                //calcola stipendio funzionante
                a.calcolaStipendio();
                System.out.println("///////////////////////////////////////");

        }catch (FileNotFoundException e) {
                    throw new RuntimeException("file non trovato");
            }
    }
}
