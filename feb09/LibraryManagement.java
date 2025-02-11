// 5. Doubly Linked List: Library Management System

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean available;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = true; // Initially available
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre + ", ID: " + bookId + ", Available: " + available;
    }
}

class Library {
    Book head;
    Book tail;

    public void addBookAtBeginning(Book newBook) {
        if (head == null) {
            head = newBook;
            tail = newBook;
            return;
        }
        newBook.next = head;
        head.prev = newBook;
        head = newBook;
    }

    public void addBookAtEnd(Book newBook) {
        if (head == null) {
            head = newBook;
            tail = newBook;
            return;
        }
        tail.next = newBook;
        newBook.prev = tail;
        tail = newBook;
    }

    public void addBookAtPosition(Book newBook, int position) {
        if (position <= 0) {
            addBookAtBeginning(newBook);
            return;
        }
        if (head == null) return; //List is empty

        Book current = head;
        int count = 0;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) { // Position is out of range
            addBookAtEnd(newBook); // Or handle as error
            return;
        }

        newBook.next = current.next;
        newBook.prev = current;
        if (current.next != null) {
            current.next.prev = newBook;
        } else {
            tail = newBook; // Update tail if inserting at the end
        }
        current.next = newBook;
    }


    public void removeBookById(int bookId) {
        if (head == null) return;

        if (head.bookId == bookId) {
            head = head.next;
            if (head != null) head.prev = null;
            if (head == null) tail = null; //If head becomes null tail should also be null
            return;
        }

        Book current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }

        if (current != null) {
            if (current == tail) {
                tail = current.prev;
                if(tail != null) tail.next = null;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
        }
    }

    public Book searchBookByTitle(String title) {
        Book current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Book searchBookByAuthor(String author) {
        Book current = head;
        while (current != null) {
            if (current.author.equals(author)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void updateAvailability(int bookId, boolean available) {
        Book book = searchBookById(bookId);
        if (book != null) {
            book.available = available;
        }
    }

    public Book searchBookById(int bookId) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    public void displayForward() {
        Book current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void displayReverse() {
        Book current = tail;
        while (current != null) {
            System.out.println(current);
            current = current.prev;
        }
    }

    public int countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBookAtEnd(new Book("Book A", "Author X", "Fiction", 1));
        library.addBookAtEnd(new Book("Book B", "Author Y", "Sci-Fi", 2));
        library.addBookAtBeginning(new Book("Book C", "Author Z", "Mystery", 3));
        library.addBookAtPosition(new Book("Book D", "Author W", "Thriller", 4), 2);

        System.out.println("Books (Forward):");
        library.displayForward();

        System.out.println("\nBooks (Reverse):");
        library.displayReverse();

        library.removeBookById(2);
        System.out.println("\nAfter removing Book 2:");
        library.displayForward();

        Book found = library.searchBookByTitle("Book A");
        if (found != null) {
            System.out.println("\nFound by title: " + found);
        }

        library.updateAvailability(1, false);
        System.out.println("\nAfter updating availability:");
        library.displayForward();

        System.out.println("\nTotal books: " + library.countBooks());
    }
}