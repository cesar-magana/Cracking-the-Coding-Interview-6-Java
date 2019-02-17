/*
 *  Cracking the Coding Interview Solutions.
 */

package Q01_08_Zero_Matrix;

/**
 *
 * @author cesar_magana
 */
public class Solution01 {
    
    public static void setZeros (int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                } 
            }
        }
        for (int i = 0; i < row.length; i++) {
            if (row[i] == true) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int j = 0; j < column.length; j++) {
            if (column[j] == true) {
                for (int i = 0; i < row.length; i++) {
                    matrix[i][j] = 0;
                }
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
            {5,5,5,0,5}
        };
        System.out.println("Input:");
        printMatrix(matrix);
        System.out.println("Output:");
        setZeros(matrix);
        printMatrix(matrix);
    }   
    
    
}
