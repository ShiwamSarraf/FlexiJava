abstract class LibraryItem {
    private String itemId;
    private String title;
    protected boolean isReserved = false;

    LibraryItem(String id, String title) {
        this.itemId = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void showDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title);
    }

    abstract void processLoan();
}

class TextBook extends LibraryItem {

    TextBook(String id, String title) {
        super(id, title);
    }

    void processLoan() {
        if (!isReserved) {
            isReserved = true;
            System.out.println("Textbook '" + getTitle() + "' issued for 14 days.");
        } else {
            System.out.println("Error: '" + getTitle() + "' is already on loan.");
        }
    }
}

class ResearchPaper extends LibraryItem {

    ResearchPaper(String id, String title) {
        super(id, title);
    }

    void processLoan() {
        System.out.println("Generating secure PDF download link for '" + getTitle() + "'.");
    }
}

public class DigitalLibrary {
    public static void main(String[] args) {

        // TC 1 & TC 2
        LibraryItem book = new TextBook("B101", "Java Core");
        book.processLoan(); // first time
        book.processLoan(); // second time

        // TC 3
        LibraryItem paper = new ResearchPaper("R99", "AI Ethics");
        paper.processLoan();
    }
}