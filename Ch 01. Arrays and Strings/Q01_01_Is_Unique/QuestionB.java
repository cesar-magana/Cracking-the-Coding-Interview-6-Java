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
public class QuestionB {

    public static boolean isUniqueChars3(String word) {
        // This code assumes that string only uses lowercase letters a-z
        int checker = 0;
        for (int i = 0; i < word.length(); i++) {
            int character = word.charAt(i) - 'a';
            if (((1 << character) & checker) > 0) return false;
            checker |= (1 << character);
        }
        return true;
    }
    
    public static boolean isUniqueChars4(String word) {
        // Time O(n^2)
        // Space O(1)
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String[] words = {"abcde", "hello", "apple", "kite", "padle","abcdefghijklmnopqrstuvwxyz","!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~a"};
        for (String word : words) {
                System.out.println(word + ": " + isUniqueChars3(word));
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Execution time: " + duration + " ms");
    }
}
