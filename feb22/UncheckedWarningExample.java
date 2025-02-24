package feb22;

import java.util.ArrayList;

public class UncheckedWarningExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Creating an ArrayList without generics
        ArrayList list = new ArrayList();
        list.add("Hello");
        list.add(123);
        
        System.out.println("List contents: " + list);
    }
} 
