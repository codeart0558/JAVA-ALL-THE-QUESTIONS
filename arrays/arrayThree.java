// 3) Program in Java to find A+B, A-B, A*B and transpose of A, where A is a matrix of 3*3 and B is a
// matrix of 3*4.Take the values in matrixes A and B from the user.
import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Matrix A (3x3)
        int[][] A = new int[3][3];
        // Matrix B (3x4)
        int[][] B = new int[3][4];

        // Input values for Matrix A
        System.out.println("Enter values for Matrix A (3x3):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter A[" + i + "][" + j + "]: ");
                A[i][j] = scanner.nextInt();
            }
        }

        // Input values for Matrix B
        System.out.println("Enter values for Matrix B (3x4):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Enter B[" + i + "][" + j + "]: ");
                B[i][j] = scanner.nextInt();
            }
        }

        // Display Matrix A and B
        System.out.println("\nMatrix A (3x3):");
        displayMatrix(A, 3, 3);

        System.out.println("\nMatrix B (3x4):");
        displayMatrix(B, 3, 4);

        // A + B (Element-wise addition of A and B)
        System.out.println("\nA + B (Matrix addition):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print((A[i][j] + B[i][j]) + " ");
            }
            System.out.println();
        }

        // A - B (Element-wise subtraction of A and B)
        System.out.println("\nA - B (Matrix subtraction):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print((A[i][j] - B[i][j]) + " ");
            }
            System.out.println();
        }

        // A * B (Matrix multiplication)
        System.out.println("\nA * B (Matrix multiplication):");
        int[][] result = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        displayMatrix(result, 3, 4);

        // Transpose of Matrix A
        System.out.println("\nTranspose of Matrix A:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(A[j][i] + " ");
            }
            System.out.println();
        }
    }

    // Method to display a matrix
    public static void displayMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
