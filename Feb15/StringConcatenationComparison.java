package Feb15;
public class StringConcatenationComparison {
    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 1_000_000};
        
        System.out.printf("%-15s %-20s %-20s %-20s%n", "Dataset Size (N)", "String (O(N²))", "StringBuilder (O(N))", "StringBuffer (O(N))");
        System.out.println("---------------------------------------------------------------");

        for (int n : sizes) {
            // Measure time for String concatenation
            long start = System.nanoTime();
            String str = "";
            for (int i = 0; i < n; i++) {
                str += "a"; // Concatenating using String (creates new object each time)
            }
            long end = System.nanoTime();
            double stringTime = (end - start) / 1e6; // Convert to milliseconds

            // Measure time for StringBuilder concatenation
            start = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append("a"); // Concatenating using StringBuilder (mutable)
            }
            end = System.nanoTime();
            double stringBuilderTime = (end - start) / 1e6; // Convert to milliseconds

            // Measure time for StringBuffer concatenation
            start = System.nanoTime();
            StringBuffer sf = new StringBuffer();
            for (int i = 0; i < n; i++) {
                sf.append("a"); // Concatenating using StringBuffer (mutable, thread-safe)
            }
            end = System.nanoTime();
            double stringBufferTime = (end - start) / 1e6; // Convert to milliseconds

            // Output the time taken for each string concatenation method
            System.out.printf("%-15d %-20.2f %-20.2f %-20.2f%n", n, stringTime, stringBuilderTime, stringBufferTime);
        }
    }
}

