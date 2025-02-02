package jan31;

class BookSec {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayBookInfo() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book {
    private String format; //EBook specific instance variable

    public EBook(String ISBN, String title, String author, String format) {
        super(ISBN, title, author); // Call the superclass constructor
        this.format = format;
    }

    public void displayEBookInfo() {
        System.out.println("ISBN: " + ISBN);       // Accessing public member (ISBN)
        System.out.println("Title: " + title);      // Accessing protected member (title)
        // System.out.println("Author: " + author); // Cannot access private member (author) directly
        System.out.println("Format: " + format);
    }
}

public class Booksec {
    public static void main(String[] args) {
        Book book1 = new Book("978-0321765723", "Effective Java", "Joshua Bloch");
        book1.displayBookInfo();

        System.out.println("\nUpdating Book 1's Author:");
        book1.setAuthor("A new Author");
        book1.displayBookInfo();

        EBook eBook1 = new EBook("978-1491928955", "Head First Java", "Bert Bates", "PDF");
        System.out.println("\nEBook Information:");
        eBook1.displayEBookInfo();

        // Trying to access private member directly (will cause a compile error)
        // System.out.println("Author: " + book1.author); // This will not compile

        // Accessing public and protected members:
        System.out.println("\nAccessing public and protected members:");
        System.out.println("ISBN: " + book1.ISBN);   // Public access
        System.out.println("Title: " + eBook1.title); // Protected access from subclass

    }
}
