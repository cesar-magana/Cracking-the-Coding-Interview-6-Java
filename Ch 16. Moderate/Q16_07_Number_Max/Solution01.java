/*
 *  Cracking the Coding Interview Solutions.
 */
package Q16_07_Number_Max;

/**
 *
 * @author cesar_magana
 */
public class Solution01 {

    public static int getMax(int a, int b) {
        return a - ((a - b) & ((a - b) >> 31));
    }

    public static void main(String[] args) {
        int a = 26;
        int b = -15;
        System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));
        a = -15;
        b = 2147483647;
        System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));
    }
}
