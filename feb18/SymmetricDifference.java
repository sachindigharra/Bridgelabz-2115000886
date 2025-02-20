import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        
        Set<Integer> symmetricDiff = new HashSet<>(set1);
        symmetricDiff.addAll(set2);
        
        Set<Integer> temp = new HashSet<>(set1);
        temp.retainAll(set2);
        
        symmetricDiff.removeAll(temp);
        
        System.out.println("Symmetric Difference: " + symmetricDiff);
    }
}