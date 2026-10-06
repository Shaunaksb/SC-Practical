import java.util.Scanner;

/**
 * Question 7: Alpha-Cut of Fuzzy Sets and Fuzzy Relations
 *
 * Definition:
 *   For alpha in [0, 1]:
 *   1. Fuzzy Set Alpha-Cut:
 *      A_alpha = { x | mu_A(x) >= alpha } -> represented as crisp 1/0
 *   2. Fuzzy Relation Alpha-Cut:
 *      R_alpha = { (x, y) | mu_R(x, y) >= alpha } -> represented as crisp matrix
 */
public class Q7_AlphaCut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter threshold alpha (between 0.0 and 1.0): ");
        double alpha = sc.nextDouble();

        // 1. Alpha-cut of Fuzzy Set
        System.out.print("\nEnter number of elements in fuzzy set A: ");
        int n = sc.nextInt();
        double[] A = new double[n];
        System.out.println("Enter membership values for set A:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextDouble();
        }

        int[] setAlphaCut = new int[n];
        for (int i = 0; i < n; i++) {
            setAlphaCut[i] = (A[i] >= alpha) ? 1 : 0;
        }

        System.out.println("\n--- ALPHA-CUT OF FUZZY SET (alpha = " + alpha + ") ---");
        System.out.print("Crisp vector: { ");
        for (int val : setAlphaCut) {
            System.out.print(val + " ");
        }
        System.out.println("}");

        System.out.print("Selected elements (indices): ");
        for (int i = 0; i < n; i++) {
            if (setAlphaCut[i] == 1) {
                System.out.print("x" + (i + 1) + " ");
            }
        }
        System.out.println();

        // 2. Alpha-cut of Fuzzy Relation
        System.out.print("\nEnter relation dimensions (rows and cols): ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        double[][] R = new double[rows][cols];
        System.out.println("Enter relation matrix values:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                R[i][j] = sc.nextDouble();
            }
        }

        int[][] relAlphaCut = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                relAlphaCut[i][j] = (R[i][j] >= alpha) ? 1 : 0;
            }
        }

        System.out.println("\n--- ALPHA-CUT OF FUZZY RELATION (alpha = " + alpha + ") ---");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(relAlphaCut[i][j] + "\t");
            }
            System.out.println();
        }

        sc.close();
    }
}
