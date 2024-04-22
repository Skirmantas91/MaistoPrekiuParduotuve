public class Mėsa extends Produktas {
    String rusis;

    public Mėsa(int kodas, String pavadinimas, double kaina, String galiojimoData, String rusis) {
        super(kodas, pavadinimas, kaina, galiojimoData, false, rusis);
        this.rusis = rusis;
    }

    public String getRusis() {
        return rusis;
    }

    public void setRusis(String rusis) {
        this.rusis = rusis;
    }

    public String toString() {
        return super.toString() + ", Rūšis: " + rusis;
    }
}