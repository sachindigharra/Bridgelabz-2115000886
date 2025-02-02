class Book {
    String title;
    String author;
    double price;

    // Default Constructor
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized Constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book information (optional, but useful)
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        // Create some Book objects using different constructors
        Book book1 = new Book(); // Using the default constructor
        Book book2 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 25.99); // Parameterized constructor
        Book book3 = new Book("Pride and Prejudice", "Jane Austen", 12.50);

        // Display the book information
        System.out.println("Book 1:");
        book1.displayBookInfo();

        System.out.println("\nBook 2:");
        book2.displayBookInfo();

        System.out.println("\nBook 3:");
        book3.displayBookInfo();


        //Demonstrating how to access and modify book properties:
        System.out.println("\nModifying Book 3:");
        book3.price = 15.00; // Changing the price
        book3.displayBookInfo();

        //Accessing the title:
        System.out.println("\nBook 2 Title: " + book2.title);

    }
}