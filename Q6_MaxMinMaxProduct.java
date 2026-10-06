import java.util.Scanner;

/**
 * Question 6: Max-Min and Max-Product Composition of Fuzzy Relations
 *
 * Given R1 (size m x k) and R2 (size k x p):
 * 1. Max-Min Composition:
 *    T_min(i, j)  = max_k { min( R1(i, k), R2(k, j) ) }
 *
 * 2. Max-Product Composition:
 *    T_prod(i, j) = max_k { R1(i, k) * R2(k, j) }
 */
public class Q6_MaxMinMaxProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter dimensions of Relation R1 (rows m and cols k): ");
        int m = sc.nextInt();
        int k = sc.nextInt();

        double[][] R1 = new double[m][k];
        System.out.println("Enter values for R1 (" + m + "x" + k + "):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                R1[i][j] = sc.nextDouble();
            }
        }

        System.out.print("Enter columns of Relation R2 (rows is " + k + ", enter cols p): ");
        int p = sc.nextInt();

        double[][] R2 = new double[k][p];
        System.out.println("Enter values for R2 (" + k + "x" + p + "):");
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < p; j++) {
                R2[i][j] = sc.nextDouble();
            }
        }

        double[][] maxMin = new double[m][p];
        double[][] maxProduct = new double[m][p];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                double curMaxMin = 0.0;
                double curMaxProd = 0.0;

                for (int x = 0; x < k; x++) {
                    // Max-Min: max over min
                    double minVal = Math.min(R1[i][x], R2[x][j]);
                    if (minVal > curMaxMin) {
                        curMaxMin = minVal;
                    }

                    // Max-Product: max over product
                    double prodVal = R1[i][x] * R2[x][j];
                    if (prodVal > curMaxProd) {
                        curMaxProd = prodVal;
                    }
                }

                maxMin[i][j] = curMaxMin;
                maxProduct[i][j] = curMaxProd;
            }
        }

        System.out.println("\n--- MAX-MIN COMPOSITION MATRIX ---");
        printMatrix(maxMin, m, p);

        System.out.println("\n--- MAX-PRODUCT COMPOSITION MATRIX ---");
        printMatrix(maxProduct, m, p);

        sc.close();
    }

    private static void printMatrix(double[][] mat, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%.2f\t", mat[i][j]);
            }
            System.out.println();
        }
    }
}
