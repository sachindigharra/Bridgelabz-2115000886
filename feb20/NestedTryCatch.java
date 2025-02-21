public class NestedTryCatch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int divisor = 0;
        int index = 2;

        try {
            try {
                int element = arr[index];
                int result = element / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
} 