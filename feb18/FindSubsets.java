import java.util.*;
public class FindSubsets {
    public static boolean isSubset(Set<Integer> subset, Set<Integer> mainSet) {
        return mainSet.containsAll(subset);
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(isSubset(set1, set2));
    }
} 
