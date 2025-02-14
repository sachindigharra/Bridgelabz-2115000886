public class Frequency {
    public static void countingSort(int[] arr, int max) {
        int[] count = new int[max + 1];
        for (int num : arr) count[num]++;
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i]-- > 0) arr[index++] = i;
        }
    }
    public static void main(String[] args) {
        int[]arr = {1,4,5,6,3,4,6,12,34,2,0};
        countingSort(arr, 36);
    }
}
