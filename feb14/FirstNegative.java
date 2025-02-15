
public class FirstNegative {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 7, -1, 2};
        System.out.println("First negative index: " + findFirstNegative(nums));
    }
}

