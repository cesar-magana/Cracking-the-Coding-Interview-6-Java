/*
 *  Cracking the Coding Interview Solutions.
 */

package Q01_04_Palindrome_Permutation;

import java.util.HashMap;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a 
 * permutation of a palindrome. A palindrome is a word or phrase that is the same 
 * forwards and backwards. A permutation is a rearrangement of letters. The 
 * palindrome does not need to be limited to just dictionary words. 
 * @author cesar_magana
 */
public class Question {
    
    public static boolean isPermutationOfPalindrome(String str) {
        int[] alphabet = new int[256];
        int oddCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                int ch = (int) str.charAt(i);
                alphabet[ch]++;
            }
        }
        for (int i = 0; i < 256; i++) {
            if (alphabet[i] %2 == 1) {
                oddCount++;
            }
            if (oddCount > 1) return false;
        }
        return true;
    }
    
    public static boolean isPermutationOfPalindrome2(String str) {
        HashMap<Character,Integer> hash = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                if (hash.containsKey(ch)) {
                    hash.put(ch, hash.get(ch) + 1);
                }
                else {
                    hash.put(ch, 1);
                }
            }
        }
        int oddCount = 0;
        for (int value : hash.values()) {
            if (value %2 == 1) oddCount++;
            if (oddCount > 1) return false;
        }
        return true;
    }

    public static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue('c');
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }
    
    public static int[] buildFrequencyTable(String str) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : str.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }
    
    public static boolean checkMaxOneOdd (int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count %2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }
    
    public static boolean isPermutationOfPalindrome3(String str) {
        // Check why this one is not working
        int[] table = buildFrequencyTable(str);
        return checkMaxOneOdd(table);
    }
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String[] palindromes = {"rats live on no evil star","anita lava la tina", "gato gatito","ce reptile lit perec"};
        for (String palindrom : palindromes) {
            System.out.println(palindrom + ": "+ isPermutationOfPalindrome(palindrom));
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Execution time: " + duration + " ms");
    }
}
