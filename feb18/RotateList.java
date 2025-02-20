import java.util.*;
public class RotateList {
    public static <T> List<T> rotate(List<T> list, int positions) {
        List<T> rotated = new ArrayList<>(list);
        Collections.rotate(rotated, -positions);
        return rotated;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        System.out.println(rotate(list, 2));
    }
}