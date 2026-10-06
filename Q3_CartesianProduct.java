import java.util.Scanner;

/**
 * Question 3: Cartesian Product of Fuzzy Sets
 * Formula:
 *   R = A x B
 *   mu_R(x, y) = min(mu_A(x), mu_B(y))
 */
public class Q3_CartesianProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in Set A: ");
        int n = sc.nextInt();
        double[] A = new double[n];
        System.out.println("Enter membership values for Set A:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextDouble();
        }

        System.out.print("Enter number of elements in Set B: ");
        int m = sc.nextInt();
        double[] B = new double[m];
        System.out.println("Enter membership values for Set B:");
        for (int j = 0; j < m; j++) {
            B[j] = sc.nextDouble();
        }

        double[][] R = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                R[i][j] = Math.min(A[i], B[j]);
            }
        }

        System.out.println("\n--- CARTESIAN PRODUCT RELATION MATRIX (R = A x B) ---");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%.2f\t", R[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}
