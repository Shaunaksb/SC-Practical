import java.util.Scanner;

/**
 * Question 1: Fuzzy Set Operations (Union, Intersection, Complement)
 * Formulae:
 *   Union:        mu_(A U B)(x) = max(mu_A(x), mu_B(x))
 *   Intersection: mu_(A ^ B)(x) = min(mu_A(x), mu_B(x))
 *   Complement:   mu_(A')(x)    = 1 - mu_A(x)
 */
public class Q1_FuzzyOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in fuzzy sets: ");
        int n = sc.nextInt();

        double[] A = new double[n];
        double[] B = new double[n];

        System.out.println("Enter membership values for Set A (between 0 and 1):");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextDouble();
        }

        System.out.println("Enter membership values for Set B (between 0 and 1):");
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextDouble();
        }

        double[] union = new double[n];
        double[] intersection = new double[n];
        double[] complementA = new double[n];
        double[] complementB = new double[n];

        for (int i = 0; i < n; i++) {
            union[i] = Math.max(A[i], B[i]);
            intersection[i] = Math.min(A[i], B[i]);
            complementA[i] = 1.0 - A[i];
            complementB[i] = 1.0 - B[i];
        }

        System.out.println("\n--- RESULTS ---");
        System.out.print("Set A:        ");
        printSet(A);
        System.out.print("Set B:        ");
        printSet(B);
        System.out.print("Union (A U B):       ");
        printSet(union);
        System.out.print("Intersection (A ^ B):");
        printSet(intersection);
        System.out.print("Complement (A'):     ");
        printSet(complementA);
        System.out.print("Complement (B'):     ");
        printSet(complementB);

        sc.close();
    }

    private static void printSet(double[] set) {
        System.out.print("{ ");
        for (double val : set) {
            System.out.printf("%.2f ", val);
        }
        System.out.println("}");
    }
}
