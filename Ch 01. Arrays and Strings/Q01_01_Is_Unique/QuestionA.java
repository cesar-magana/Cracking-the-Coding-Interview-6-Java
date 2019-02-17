/*
 * Cracking the Coding Interview Solutions.
 */
package Q01_01_Is_Unique;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique 
 * characters. 
 * What if you cannot use additional data structures
 * 
 * @author cesar_magana
 */
public class QuestionA {

    public static boolean isUniqueChars1(String word) {
        // Complexity O(n log n )
        // Space depending on sorting algorithm
        char[] sorted = word.toCharArray();
        Arrays.sort(sorted);
        for (int i = 1; i < sorted.length - 1; i++) {
            if (sorted[i] == sorted[i+1]) return false;
        }
        return true;
    }

    public static boolean isUniqueChars2(String word) {
        // Complexity O(n)/O(128)/O(c)
        // Space O(1)
        if (word.length() > 128) return false;
        boolean[] alphabet = new boolean[128];
        for (int i = 0; i < word.length(); i++) {
            int character = word.charAt(i);
            if (alphabet[character] == true) {
                return false;
            }
            alphabet[character] = true;
        }
        return true;
    }
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String[] words = {"abcde", "hello", "apple", "kite", "padle","abcdefghijklmnopqrstuvwxyz","!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~a"};
        for (String word : words) {
                System.out.println(word + ": " + isUniqueChars1(word));
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Execution time: " + duration + " ms");
    }
}
