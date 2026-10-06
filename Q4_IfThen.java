import java.util.Scanner;

/**
 * Question 4: Fuzzy IF-THEN Rule (IF A THEN B)
 * Computes the fuzzy implication relation matrix R.
 *
 * 1. Mamdani Rule (Min Implication - standard in lab):
 *    R(x, y) = min(mu_A(x), mu_B(y))
 *
 * 2. Zadeh Implication:
 *    R(x, y) = max( min(mu_A(x), mu_B(y)), 1 - mu_A(x) )
 */
public class Q4_IfThen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of antecedent fuzzy set A: ");
        int n = sc.nextInt();
        double[] A = new double[n];
        System.out.println("Enter membership values for set A:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextDouble();
        }

        System.out.print("Enter size of consequent fuzzy set B: ");
        int m = sc.nextInt();
        double[] B = new double[m];
        System.out.println("Enter membership values for set B:");
        for (int j = 0; j < m; j++) {
            B[j] = sc.nextDouble();
        }

        double[][] mamdaniR = new double[n][m];
        double[][] zadehR = new double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Mamdani implication: min(A[i], B[j])
                mamdaniR[i][j] = Math.min(A[i], B[j]);

                // Zadeh implication: max(min(A[i], B[j]), 1 - A[i])
                double minVal = Math.min(A[i], B[j]);
                zadehR[i][j] = Math.max(minVal, 1.0 - A[i]);
            }
        }

        System.out.println("\n--- MAMDANI IMPLICATION (Standard Min Rule) ---");
        printMatrix(mamdaniR, n, m);

        System.out.println("\n--- ZADEH IMPLICATION ---");
        printMatrix(zadehR, n, m);

        sc.close();
    }

    private static void printMatrix(double[][] mat, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%.2f\t", mat[i][j]);
            }
            System.out.println();
        }
    }
}
