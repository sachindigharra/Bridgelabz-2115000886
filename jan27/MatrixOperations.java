import java.util.Random;

public class MatrixOperations {

    public static void main(String[] args) {
        int rows1 = 3, cols1 = 3;
        int rows2 = 3, cols2 = 3;

        int[][] matrix1 = generateRandomMatrix(rows1, cols1);
        int[][] matrix2 = generateRandomMatrix(rows2, cols2);

        System.out.println("Matrix 1:");
        displayMatrix(matrix1);
        System.out.println("Matrix 2:");
        displayMatrix(matrix2);

        if (rows1 == rows2 && cols1 == cols2) {
            int[][] sumMatrix = addMatrices(matrix1, matrix2);
            System.out.println("Sum:");
            displayMatrix(sumMatrix);

            int[][] differenceMatrix = subtractMatrices(matrix1, matrix2);
            System.out.println("Difference:");
            displayMatrix(differenceMatrix);
        }

        if (cols1 == rows2) {
            int[][] productMatrix = multiplyMatrices(matrix1, matrix2);
            System.out.println("Product:");
            displayMatrix(productMatrix);
        }

        int[][] transposeMatrix1 = transposeMatrix(matrix1);
        System.out.println("Transpose of Matrix 1:");
        displayMatrix(transposeMatrix1);

        if (matrix1.length == 2 && matrix1[0].length == 2) {
            double determinant1 = determinant2x2(matrix1);
            System.out.println("Determinant of Matrix 1 (2x2): " + determinant1);

            if (determinant1 != 0) {
                double[][] inverseMatrix1 = inverse2x2(matrix1);
                                System.out.println("Inverse of Matrix 1 (2x2):");
                                //displayMatrix(inverseMatrix1); 
                            } else {
                                System.out.println("Matrix 1 (2x2) is singular (no inverse).");
                            }
                        } else if (matrix1.length == 3 && matrix1[0].length == 3) {
                            double determinant1 = determinant3x3(matrix1);
                            System.out.println("Determinant of Matrix 1 (3x3): " + determinant1);
                
                            if (determinant1 != 0) {
                                // Implement inverse3x3 method here
                                // double[][] inverseMatrix1 = inverse3x3(matrix1); 
                                // System.out.println("Inverse of Matrix 1 (3x3):");
                                // displayMatrix(inverseMatrix1); 
                            } else {
                                System.out.println("Matrix 1 (3x3) is singular (no inverse).");
                            }
                        }
                    }
                
                    private static double[][] inverse2x2(int[][] matrix1) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'inverse2x2'");
                    }
                
                    public static int[][] generateRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); // Random values between 0 and 9
            }
        }

        return matrix;
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] sum = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return sum;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] difference = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                difference[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return difference;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;
        int[][] product = new int[rows1][cols2];

        if (cols1 != rows2) {
            System.out.println("Matrix multiplication not possible. Incompatible dimensions.");
            return null;
        }

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    product[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return product;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

    public static double determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static double determinant3x3(int[][] matrix) {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) -
               matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) +
               matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    // Implement inverse3x3 method here
    // ...

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}