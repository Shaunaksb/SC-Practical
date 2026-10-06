import java.util.Scanner;

/**
 * Question 8: Linguistic Term, Composite, and Hedges
 *
 * Concepts:
 * 1. Primary Linguistic Term: Base fuzzy set (e.g., "Young")
 * 2. Hedges (Modifiers):
 *    - Concentration ("Very A"):        mu(x)^2
 *    - Dilation ("Somewhat / More-or-Less A"): sqrt(mu(x))
 *    - Negation ("Not A"):              1 - mu(x)
 *    - Intensification ("Extremely A"): mu(x)^3
 * 3. Composite Term: Combining hedges using fuzzy AND (min) / OR (max):
 *    - "Very A AND Not A": min(Very(A), Not(A))
 */
public class Q8_LinguisticHedges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in universe of discourse: ");
        int n = sc.nextInt();

        double[] term = new double[n];
        System.out.println("Enter membership values for primary term (e.g., 'Young'):");
        for (int i = 0; i < n; i++) {
            term[i] = sc.nextDouble();
        }

        double[] veryTerm = new double[n];
        double[] somewhatTerm = new double[n];
        double[] notTerm = new double[n];
        double[] extremelyTerm = new double[n];
        double[] compositeTerm = new double[n]; // Example: Very A AND Not A

        for (int i = 0; i < n; i++) {
            veryTerm[i] = Math.pow(term[i], 2);           // Very (Concentration)
            somewhatTerm[i] = Math.sqrt(term[i]);          // Somewhat (Dilation)
            notTerm[i] = 1.0 - term[i];                    // Not (Negation)
            extremelyTerm[i] = Math.pow(term[i], 3);      // Extremely (Intensification)

            // Composite: "Very A AND Not A"
            compositeTerm[i] = Math.min(veryTerm[i], notTerm[i]);
        }

        System.out.println("\n--- LINGUISTIC TERMS & HEDGES ---");
        System.out.print("1. Primary Term (A)          : ");
        printArray(term);

        System.out.print("2. Hedge 'Very A' (A^2)       : ");
        printArray(veryTerm);

        System.out.print("3. Hedge 'Somewhat A' (sqrt A): ");
        printArray(somewhatTerm);

        System.out.print("4. Hedge 'Not A' (1 - A)      : ");
        printArray(notTerm);

        System.out.print("5. Hedge 'Extremely A' (A^3)  : ");
        printArray(extremelyTerm);

        System.out.println("\n--- COMPOSITE TERM ---");
        System.out.print("Composite ('Very A AND Not A'): ");
        printArray(compositeTerm);

        sc.close();
    }

    private static void printArray(double[] arr) {
        System.out.print("{ ");
        for (double val : arr) {
            System.out.printf("%.2f ", val);
        }
        System.out.println("}");
    }
}
