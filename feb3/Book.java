package feb3;

public class  Book {
    String title;
    String author;
    final int isbn;

    static void libraryName(){

    }
    static void displayLibraryName(){

    }
    public   Book(String title,String author,int isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;

    }
    public static void main(String[] args) {
       Book  book = new Book("Death Note", "Sachin Sharma", 31941);
        if(book instanceof Book){
             
             System.out.println(book.title);
             System.out.println(book.author);
             System.out.println(book.isbn);
            
        }
        else{
         System.out.println("This object is not onj of Book Class");
        }
    }
}
