/*
 *  Cracking the Coding Interview Solutions.
 */

package Q01_02_Check_Permutation;

import java.util.Arrays;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other. 
 * @author cesar_magana
 */
public class QuestionA {
    
    public static boolean permutation1 (String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        char[] sorted1 = word1.toCharArray();
        char[] sorted2 = word2.toCharArray();
        Arrays.sort(sorted1);
        Arrays.sort(sorted2);
        for (int i = 0; i < word1.length(); i++) {
            if (sorted1[i] != sorted2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean permutation2 (String word1, String word2) {
        if (word1.length() != word2.length() ) {
            return false;
        }
        int letters[] = new int[128];
        for (int i = 0; i < 128; i++) letters[i] = 0;
        char[] array = word1.toCharArray();
        for (char ch : array) {
            letters[(int)ch]++;
        }
        for (int i = 0; i < word2.length(); i++) {
            int ch = word2.charAt(i);
            letters[ch]--;
            if (letters[ch] < 0) {
                return false;
            }
        }
        return true;
    }
    
    public static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    public static boolean permutation3 (String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        return sort(word1).equals(sort(word2));
    }
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
                String word1 = pair[0];
                String word2 = pair[1];
                boolean anagram = permutation1(word1, word2);
                System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Execution time: " + duration + " ms");
    }
}