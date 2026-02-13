import java.util.ArrayList;

class Book {
    String title, author, isbn;

    Book(String t, String a, String i) {
        title = t;
        author = a;
        isbn = i;
    }

    void display() {
        System.out.println("Title: " + title + " | Author: " + author + " | ISBN: " + isbn);
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    Book searchByTitle(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    void displayAllBooks() {
        for (Book b : books) b.display();
    }
}

public class Lib_Mag_Sys {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new Book("Java Basics", "Poshak", "12345"));
        lib.addBook(new Book("AR/VR Design", "Thakur", "67890"));

        System.out.println("All Books:");
        lib.displayAllBooks();

        System.out.println("\nSearching for 'Java Basics':");
        Book found = lib.searchByTitle("Java Basics");
        if (found != null) found.display();
    }
    
}
