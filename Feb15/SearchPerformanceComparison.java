package Feb15;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class SearchAlgorithms {
    // Linear Search: Scan each element to find the target
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Binary Search: Sort first, then perform binary search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}

public class SearchPerformanceComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the total number of datasets from user input
        System.out.print("Enter the total number of datasets: ");
        int datasetCount = scanner.nextInt();
        int[] sizes = new int[datasetCount];

        // Generate dataset sizes for comparison
        for (int i = 0; i < datasetCount; i++) {
            sizes[i] = (int) Math.pow(10, 3 + i);  // Generating sizes 1000, 10000, 100000, etc.
        }

        Random rand = new Random();
        System.out.printf("%-15s %-20s %-20s%n", "Dataset Size (N)", "Linear Search (O(N))", "Binary Search (O(log N))");
        System.out.println("--------------------------------------------------------------");

        // Perform search comparisons for each dataset size
        for (int n : sizes) {
            // Generate an array with random integers
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(n * 10);  // Random numbers between 0 and n*10
            }

            // Pick a random target for both searches
            int target = arr[rand.nextInt(n)];

            // Measure time taken by Linear Search
            long start = System.nanoTime();
            SearchAlgorithms.linearSearch(arr, target);
            long end = System.nanoTime();
            double linearTime = (end - start) / 1e6; // Convert to milliseconds

            // Measure time taken by Binary Search (after sorting the array)
            Arrays.sort(arr);
            start = System.nanoTime();
            SearchAlgorithms.binarySearch(arr, target);
            end = System.nanoTime();
            double binaryTime = (end - start) / 1e6; // Convert to milliseconds

            // Output the time taken for both searches
            System.out.printf("%-15d %-20.2f %-20.2f%n", n, linearTime, binaryTime);
        }

        scanner.close();
    }
}
