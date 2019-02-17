/*
 *  Cracking the Coding Interview Solutions.
 */
package Q16_01_Number_Swapper;

/**
 *
 * @author cesar_magana
 */
public class Solution02 {

    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        a = a * b;
        b = a / b;
        a = a / b;
        System.out.printf("a = %d, b = %d \n", a, b);
    }
}
