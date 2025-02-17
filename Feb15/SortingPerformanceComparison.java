package Feb15;

import java.util.Arrays;
import java.util.Random;

class SortAlgorithms {

    // Bubble Sort (Inefficient for large datasets)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort (Efficient and stable)
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        
        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // Quick Sort (Efficient but unstable)
    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortHelper(arr, low, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

public class SortingPerformanceComparison {
    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 1_000_000};
        Random rand = new Random();

        System.out.printf("%-15s %-20s %-20s %-20s%n", "Dataset Size (N)", "Bubble Sort (O(N²))", "Merge Sort (O(N log N))", "Quick Sort (O(N log N))");
        System.out.println("---------------------------------------------------------------");

        for (int n : sizes) {
            // Create a random array for each dataset size
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(n * 10); // Random numbers between 0 and n*10
            }

            // Measure Bubble Sort time
            int[] bubbleArr = Arrays.copyOf(arr, arr.length);
            long start = System.nanoTime();
            SortAlgorithms.bubbleSort(bubbleArr);
            long end = System.nanoTime();
            double bubbleTime = (end - start) / 1e6; // Convert to milliseconds

            // Measure Merge Sort time
            int[] mergeArr = Arrays.copyOf(arr, arr.length);
            start = System.nanoTime();
            SortAlgorithms.mergeSort(mergeArr);
            end = System.nanoTime();
            double mergeTime = (end - start) / 1e6; // Convert to milliseconds

            // Measure Quick Sort time
            int[] quickArr = Arrays.copyOf(arr, arr.length);
            start = System.nanoTime();
            SortAlgorithms.quickSort(quickArr);
            end = System.nanoTime();
            double quickTime = (end - start) / 1e6; // Convert to milliseconds

            // Output the time taken for each sorting algorithm
            System.out.printf("%-15d %-20.2f %-20.2f %-20.2f%n", n, bubbleTime, mergeTime, quickTime);
        }
    }
}

