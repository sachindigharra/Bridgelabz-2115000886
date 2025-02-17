package Feb15;

public class FibonacciComparison {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] fibonacciNumbers = {10, 30, 50}; // Fibonacci sequence numbers to test

        // Measure time for Recursive approach
        System.out.printf("%-15s %-25s %-25s%n", "Fibonacci (N)", "Recursive Time (O(2^n))", "Iterative Time (O(N))");
        System.out.println("---------------------------------------------------------------");

        for (int n : fibonacciNumbers) {
            // Measure time for Recursive Fibonacci
            long start = System.nanoTime();
            fibonacciRecursive(n);
            long end = System.nanoTime();
            double recursiveTime = (end - start) / 1e6; // Convert to milliseconds

            // Measure time for Iterative Fibonacci
            start = System.nanoTime();
            fibonacciIterative(n);
            end = System.nanoTime();
            double iterativeTime = (end - start) / 1e6; // Convert to milliseconds

            // Output the time taken for each approach
            System.out.printf("%-15d %-25.2f %-25.2f%n", n, recursiveTime, iterativeTime);
        }
    }
}

