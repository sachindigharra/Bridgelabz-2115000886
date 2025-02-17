package Feb15;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Random;

public class DataStructureSearchComparison {

    // Method to perform linear search in an array
    public static boolean arraySearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] sizes = {1_000, 100_000, 1_000_000};
        Random rand = new Random();

        System.out.printf("%-15s %-20s %-20s %-20s%n", "Dataset Size (N)", "Array Search", "HashSet Search", "TreeSet Search");
        System.out.println("-------------------------------------------------------------");

        for (int n : sizes) {
            int[] arr = rand.ints(n, 0, n * 10).toArray();
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            // Populate HashSet and TreeSet
            for (int i = 0; i < n; i++) {
                int num = rand.nextInt(n * 10);
                hashSet.add(num);
                treeSet.add(num);
            }

            int target = arr[rand.nextInt(n)]; // Pick a random target to search for

            // Measure Array Search Time
            long start = System.nanoTime();
            arraySearch(arr, target);
            long end = System.nanoTime();
            double arrayTime = (end - start) / 1e6; // Convert to milliseconds

            // Measure HashSet Search Time
            start = System.nanoTime();
            hashSet.contains(target);
            end = System.nanoTime();
            double hashSetTime = (end - start) / 1e6; // Convert to milliseconds

            // Measure TreeSet Search Time
            start = System.nanoTime();
            treeSet.contains(target);
            end = System.nanoTime();
            double treeSetTime = (end - start) / 1e6; // Convert to milliseconds

            System.out.printf("%-15d %-20.2f %-20.2f %-20.2f%n", n, arrayTime, hashSetTime, treeSetTime);
        }
    }
}
