import java.util.Scanner;

/**
 * Question 2: De Morgan's Laws for Fuzzy Sets
 * Law 1: (A U B)' = A' ^ B'
 * Law 2: (A ^ B)' = A' U B'
 */
public class Q2_DeMorganLaw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in fuzzy sets: ");
        int n = sc.nextInt();

        double[] A = new double[n];
        double[] B = new double[n];

        System.out.println("Enter membership values for Set A:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextDouble();
        }

        System.out.println("Enter membership values for Set B:");
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextDouble();
        }

        boolean law1Holds = true;
        boolean law2Holds = true;

        System.out.println("\n--- VERIFYING DE MORGAN'S LAW 1: (A U B)' = A' ^ B' ---");
        for (int i = 0; i < n; i++) {
            double lhs1 = 1.0 - Math.max(A[i], B[i]);
            double rhs1 = Math.min(1.0 - A[i], 1.0 - B[i]);
            System.out.printf("Element %d: LHS = %.2f | RHS = %.2f\n", (i + 1), lhs1, rhs1);
            if (Math.abs(lhs1 - rhs1) > 1e-6) {
                law1Holds = false;
            }
        }
        System.out.println("Law 1 Holds: " + law1Holds);

        System.out.println("\n--- VERIFYING DE MORGAN'S LAW 2: (A ^ B)' = A' U B' ---");
        for (int i = 0; i < n; i++) {
            double lhs2 = 1.0 - Math.min(A[i], B[i]);
            double rhs2 = Math.max(1.0 - A[i], 1.0 - B[i]);
            System.out.printf("Element %d: LHS = %.2f | RHS = %.2f\n", (i + 1), lhs2, rhs2);
            if (Math.abs(lhs2 - rhs2) > 1e-6) {
                law2Holds = false;
            }
        }
        System.out.println("Law 2 Holds: " + law2Holds);

        sc.close();
    }
}
