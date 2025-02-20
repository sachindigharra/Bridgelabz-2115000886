import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckSetEquality {
    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        return set1.equals(set2);
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        System.out.println(areSetsEqual(set1, set2));
    }
}