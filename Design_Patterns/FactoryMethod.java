interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Opening a Word document...");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening a PDF document...");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening an Excel document...");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordFactory();
        Document doc1 = wordFactory.createDocument();
        doc1.open();

        DocumentFactory pdfFactory = new PdfFactory();
        Document doc2 = pdfFactory.createDocument();
        doc2.open();

        DocumentFactory excelFactory = new ExcelFactory();
        Document doc3 = excelFactory.createDocument();
        doc3.open();
    }
}