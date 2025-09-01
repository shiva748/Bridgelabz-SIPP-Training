// Data Export Interface with default methods
interface DataExporter {
    void exportToCSV();

    void exportToPDF();

    default void exportToJSON() {
        System.out.println("Exporting data to JSON format");
    }
}

class CSVExporter implements DataExporter {
    @Override
    public void exportToCSV() {
        System.out.println("Exporting detailed data to CSV");
    }

    @Override
    public void exportToPDF() {
        System.out.println("Exporting data to PDF format");
    }
}

class PDFExporter implements DataExporter {
    @Override
    public void exportToCSV() {
        System.out.println("Exporting data to CSV format");
    }

    @Override
    public void exportToPDF() {
        System.out.println("Exporting detailed data to PDF");
    }
}

public class DataExportFeature {
    public static void main(String[] args) {
        DataExporter csvExporter = new CSVExporter();
        DataExporter pdfExporter = new PDFExporter();

        System.out.println("CSV Exporter:");
        csvExporter.exportToCSV();
        csvExporter.exportToPDF();
        csvExporter.exportToJSON();

        System.out.println("\nPDF Exporter:");
        pdfExporter.exportToCSV();
        pdfExporter.exportToPDF();
        pdfExporter.exportToJSON();
    }
}
