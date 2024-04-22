import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOManager implements CSVImportExport {
    public List<Produktas> importFromCSV(String filePath) {
        List<Produktas> produktai = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineValues = line.split(",");
                int kodas = Integer.parseInt(lineValues[0]);
                String pavadinimas = lineValues[1];
                double kaina = Double.parseDouble(lineValues[2]);
                String galiojimoData = lineValues[3];
                boolean arEkologiskas = Boolean.parseBoolean(lineValues[4]);
                String rusis = lineValues[5];

                if (lineValues[6].equals("vaisius")) {
                    produktai.add(new Vaisius(kodas, pavadinimas, kaina, galiojimoData, arEkologiskas));
                } else if (lineValues[6].equals("mėsa")) {
                    produktai.add(new Mėsa(kodas, pavadinimas, kaina, galiojimoData, rusis));
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Nepavyko skaityti failo: " + e.getMessage());
        }
        return produktai;
    }

    public void exportToCSV(List<Produktas> produktai, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Produktas produktas : produktai) {
                bufferedWriter.write(produktas.toCSVString());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Nepavyko rasyti failo: " + e.getMessage());
        }
    }

    public void addProductToCSV(Produktas produktas) {
        List<Produktas> produktai = importFromCSV(Main.outputFilePath);
        produktai.add(produktas);
        exportToCSV(produktai, Main.outputFilePath);
    }

    public void removeProductFromCSV(Produktas produktas) {
        List<Produktas> produktai = importFromCSV(Main.outputFilePath);
        produktai.removeIf(p -> p.getKodas() == produktas.getKodas());
        exportToCSV(produktai, Main.outputFilePath);
    }
}