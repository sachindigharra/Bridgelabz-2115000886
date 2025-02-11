
// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
}

// Interface Reservable
interface Reservable {
    boolean reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Book class
class Book extends LibraryItem implements Reservable {
    private boolean isReserved;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 14; // Books can be loaned for 14 days
    }

    @Override
    public boolean reserveItem(String borrowerName) {
        if (!isReserved) {
            isReserved = true;
            System.out.println("Book reserved by " + borrowerName);
            return true;
        }
        System.out.println("Book is already reserved.");
        return false;
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {
    private boolean isReserved;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 7; // Magazines can be loaned for 7 days
    }

    @Override
    public boolean reserveItem(String borrowerName) {
        if (!isReserved) {
            isReserved = true;
            System.out.println("Magazine reserved by " + borrowerName);
            return true;
        }
        System.out.println("Magazine is already reserved.");
        return false;
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    private boolean isReserved;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 3; // DVDs can be loaned for 3 days
    }

    @Override
    public boolean reserveItem(String borrowerName) {
        if (!isReserved) {
            isReserved = true;
            System.out.println("DVD reserved by " + borrowerName);
            return true;
        }
        System.out.println("DVD is already reserved.");
        return false;
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Main class to demonstrate functionality
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem book = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald");
        LibraryItem magazine = new Magazine("M001", "National Geographic", "NatGeo Team");
        LibraryItem dvd = new DVD("D001", "Inception", "Christopher Nolan");

        book.getItemDetails();
        System.out.println("Loan Duration: " + book.getLoanDuration() + " days");

        magazine.getItemDetails();
        System.out.println("Loan Duration: " + magazine.getLoanDuration() + " days");

        dvd.getItemDetails();
        System.out.println("Loan Duration: " + dvd.getLoanDuration() + " days");

        Reservable reservableBook = (Reservable) book;
        reservableBook.reserveItem("John Doe");
        System.out.println("Book Availability: " + reservableBook.checkAvailability());
    }
}

