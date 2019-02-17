/*
 *  Cracking the Coding Interview Solutions.
 */

package Q01_07_Rotate_Matrix;

/**
 *
 * @author cesar_magana
 */
public class Solution01 {
    
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first]; 			
                matrix[last-offset][first] = matrix[last][last - offset]; 
                matrix[last][last - offset] = matrix[i][last]; 
                matrix[i][last] = top;
            }
        }
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }        
    }
    
    public static void main(String[] args) {
        int n = 5;
        int[][] matrix = new int[][] {
            {1,1,1,1,1},
            {2,2,2,2,2},
            {3,3,3,3,3},
            {4,4,4,4,4},
            {5,5,5,5,5}
        };
        System.out.println("Input:");
        printMatrix(matrix);
        System.out.println("Output:");
        rotate(matrix);
        printMatrix(matrix);
    }   
}
