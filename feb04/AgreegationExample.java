
package feb04;
import java.util.*;

 class Book{
    String title;
    String author;

    public Book(String title,String author){
        this.title = title;
        this.author = author;
    }
}
 class Library {
    ArrayList<Book>books;

    public Library(){
        this.books = new ArrayList<>();
    }
    public void addBook(Book book){
        this.books.add(book);
    }
    public void getDisplayBook(){
        for(Book book : books){
            System.out.println(book.title+"  "+book.author);
        }
    }
    
}

public class AgreegationExample{
    public static void main(String[] args) {
        Library centrallib = new Library();

        Book deathnote = new Book("death note", "sachin");
        Book b1 = new Book("strugle for independence", "freedom fighters");
        centrallib.addBook(b1);
        centrallib.addBook(deathnote);
        centrallib.getDisplayBook();
    }
}