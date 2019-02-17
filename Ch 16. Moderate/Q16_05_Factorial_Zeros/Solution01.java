/*
 *  Cracking the Coding Interview Solutions.
 */
package Q16_05_Factorial_Zeros;

/**
 *
 * @author cesar_magana
 */
public class Solution01 {

    public static int countFactZeros(int num) {
        int numberOfFives = 0;
        for (int i = 5; num / i >= 1; i *= 5) {
            numberOfFives += num / i;
        }
        return numberOfFives;
    }

    public static long factorial(int num) {
        if (num < 0) {
            return -1;
        }
        long result = 1;
        for (int i = 1; i < num + 1; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            System.out.println(i + "! (or " + factorial(i) + ") has " + countFactZeros(i) + " zeros");
        }
    }

}
