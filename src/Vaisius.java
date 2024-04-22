public class Vaisius extends Produktas {
    public Vaisius(int kodas, String pavadinimas, double kaina, String galiojimoData, boolean arEkologiskas) {
        super(kodas, pavadinimas, kaina, galiojimoData, arEkologiskas, "");
    }

    public String toString() {
        return super.toString() + ", Ar ekologiskas: " + isArEkologiskas();
    }
}
