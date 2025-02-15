public class FirstLastOccurrence {
    public static int findFirstOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1, first = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid - 1;
            if (nums[mid] == target) first = mid;
            else left = mid + 1;
        }
        return first;
    }

    public static int findLastOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1, last = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            if (nums[mid] == target) last = mid;
            else right = mid - 1;
        }
        return last;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 4, 4, 5, 6, 7};
        int target = 4;
        int first = findFirstOccurrence(nums, target);
        int last = findLastOccurrence(nums, target);
        System.out.println("First Occurrence: " + first + ", Last Occurrence: " + last);
    }
}