import java.util.Arrays;

public class BubbleSort {
    
    // 1. Bubble Sort - Sort Student Marks
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    public static void main(String[] args) {
        int[] marks = {45, 89, 32, 67, 90};
        bubbleSort(marks);
        System.out.println("Sorted Marks: " + Arrays.toString(marks));
        
       
    }
}