import java.util.List;

interface CSVImportExport {
    List<Produktas> importFromCSV(String path);
    void exportToCSV(List<Produktas> produktai, String path);
    void addProductToCSV(Produktas produktas);
    void removeProductFromCSV(Produktas produktas);
}
