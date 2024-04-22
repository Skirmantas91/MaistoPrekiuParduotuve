/* Klasės struktūra:
Sukurkite bazinę klasę Produktas, kuri turėtų šias savybes:
kodas (int)
pavadinimas (String)
kaina (double)
galiojimoData (LocalDate)
Metodai: konstruktorius, getteriai/setteriai, toString().*/

public class Produktas {
    int kodas;
    String pavadinimas;
    double kaina;
    String galiojimoData;
    boolean arEkologiskas;
    String rusis;



    public Produktas(int kodas, String pavadinimas, double kaina, String galiojimoData, boolean arEkologiskas, String rusis) {
        this.kodas = kodas;
        this.pavadinimas = pavadinimas;
        this.kaina = kaina;
        this.galiojimoData = galiojimoData;
        this.arEkologiskas = arEkologiskas;
        this.rusis = rusis;
    }

    public int getKodas() {
        return kodas;
    }

    public String toCSVString() {
        String produktasType = arEkologiskas ? "vaisius" : "mėsa";
        return kodas + "," + pavadinimas + "," + kaina + "," + galiojimoData + "," + arEkologiskas + "," + rusis + "," + produktasType;
    }

    public boolean isArEkologiskas() {
        return arEkologiskas;
    }
}
