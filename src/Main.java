/*Sukurkite programą, "Maisto prekių valdymas parduotuvėje".
Programa turės gebėti skaityti, pildyti ir atnaujinti duomenis apie prekes iš CSV failo.

Reikalavimai
Klasės struktūra:
Sukurkite bazinę klasę Produktas, kuri turėtų šias savybes:
kodas (int)
pavadinimas (String)
kaina (double)
galiojimoData (LocalDate)
Metodai: konstruktorius, getteriai/setteriai, toString().
Sukurkite paveldinčiasias klases Vaisius ir Mėsa.

Kiekviena iš šių klasių turėtų turėti papildomų specifinių savybių:
Vaisius: arEkologiskas (boolean)
Mėsa: rusis (String)
Abu turėtų turėti atitinkamus konstruktorius,
getterius/setterius ir perrašytą toString() metodą.

Implementuokite sąsają CSVImportExport,
kuri turėtų metodus importuotiIsCSV(String path) ir eksportuotiICSV(List<Produktas> produktai, String path),
 pridetiProduktaICSV(Produktas produktas), pašalintiProduktaIsCSV(Produktas produktas)
 arba pašalintiProduktaIsCSV(Produktas produktas) (pasirinktinai).

Sukurkite krepšelį, jog produktus būtų galima pridėti pagal jų ID (kodą) į krepšelį,
kad būtų galima pamatyti prekių krepšelyje kainą.

Sukurkite prekių sąrašo pildymą iš konsolinės įvesties, bei ištrynimą, konsolinės įvesties pagalba */
import java.io.*;
import java.util.*;

public class Main {
    static String outputFilePath = "C:\\Users\\Mindaugas\\IdeaProjects\\MaistoPrekiuParduotuve\\src\\example.csv";

    public static void main(String[] args) {
        IOManager ioManager = new IOManager();
        List<Produktas> produktai = ioManager.importFromCSV(outputFilePath);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Įveskite produkto kodą (-1 baigti): ");
                int kodas = scanner.nextInt();
                scanner.nextLine();
                if (kodas == -1) {
                    break;
                }
                System.out.println("Įveskite produkto pavadinimą: ");
                String pavadinimas = scanner.nextLine();
                System.out.println("Įveskite produkto kainą: ");
                double kaina = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Įveskite produkto galiojimo datą (YYYY-MM-DD): ");
                String galiojimoData = scanner.nextLine();
                System.out.println("Ar tai vaisius? (T/N): ");
                boolean arEkologiskas = scanner.nextLine().equalsIgnoreCase("T");
                String rusis = "";
                if (!arEkologiskas) {
                    System.out.println("Įveskite mėsos rūšį: ");
                    rusis = scanner.nextLine();
                }
                produktai.add(new Produktas(kodas, pavadinimas, kaina, galiojimoData, arEkologiskas, rusis));
                ioManager.exportToCSV(produktai, outputFilePath);
                System.out.println("Ar norite testi? (T/N)");
                String testi = scanner.nextLine();
                if (testi.equalsIgnoreCase("N")) {
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }
    }
}