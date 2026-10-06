import java.util.Scanner;

/**
 * Question 5: Fuzzy IF A THEN B ELSE C
 * Rule formulation:
 *   (IF A THEN B) UNION (IF NOT A THEN C)
 *
 * Formula:
 *   R(x, y) = max( min(mu_A(x), mu_B(y)), min(1 - mu_A(x), mu_C(y)) )
 */
public class Q5_IfThenElse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of antecedent fuzzy set A: ");
        int n = sc.nextInt();
        double[] A = new double[n];
        System.out.println("Enter membership values for set A:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextDouble();
        }

        System.out.print("Enter size of consequent sets B and C: ");
        int m = sc.nextInt();
        double[] B = new double[m];
        double[] C = new double[m];

        System.out.println("Enter membership values for set B:");
        for (int j = 0; j < m; j++) {
            B[j] = sc.nextDouble();
        }

        System.out.println("Enter membership values for set C:");
        for (int j = 0; j < m; j++) {
            C[j] = sc.nextDouble();
        }

        double[][] R = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                double r1 = Math.min(A[i], B[j]);          // IF A THEN B
                double r2 = Math.min(1.0 - A[i], C[j]);    // IF NOT A THEN C
                R[i][j] = Math.max(r1, r2);               // UNION of both
            }
        }

        System.out.println("\n--- RELATION MATRIX FOR (IF A THEN B ELSE C) ---");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%.2f\t", R[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}
