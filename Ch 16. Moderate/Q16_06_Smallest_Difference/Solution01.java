/*
 *  Cracking the Coding Interview Solutions.
 */
package Q16_06_Smallest_Difference;

import java.util.Arrays;

/**
 *
 * @author cesar_magana
 */
public class Solution01 {
    
    public static int findSmallestDifference(int[] array1, int[] array2) {
        // Complexity: O(a loga + b logb)
        Arrays.sort(array1);
        Arrays.sort(array2);
        int a = 0;
        int b = 0;
        int min = Integer.MAX_VALUE;
        while (a < array1.length && b < array2.length) {
            int diff = Math.abs(array1[a] - array2[b]);
            if (diff < min) {
                min = diff;
            }
            if (array1[a] < array2[b]) {
                a++;
            }
            else {
                b++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 15, 11, 2};
        int[] array2 = {23, 127, 235, 19, 8};
        int difference = findSmallestDifference(array1, array2);
        System.out.println(difference);
    }
}
