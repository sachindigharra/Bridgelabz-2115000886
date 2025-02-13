import java.util.*;
public class SubarraysWithZeroSum {
    static int countZeroSumSubarrays(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        map.put(0, 1);
        for (int num : arr) {
            sum += num;
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}