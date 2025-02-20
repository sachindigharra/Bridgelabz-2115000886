import java.util.*;
public class FindNthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        ListIterator<T> first = list.listIterator();
        ListIterator<T> second = list.listIterator();
        for (int i = 0; i < n; i++) first.next();
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        return second.next();
    }
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println(findNthFromEnd(list, 2));
    }
}
