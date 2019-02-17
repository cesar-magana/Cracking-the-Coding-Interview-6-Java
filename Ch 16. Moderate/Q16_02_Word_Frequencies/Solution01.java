/*
 *  Cracking the Coding Interview Solutions.
 */
package Q16_02_Word_Frequencies;

import CtCILibrary.AssortedMethods;
import java.util.HashMap;

/**
 *
 * @author cesar_magana
 */
public class Solution01 {

    public static int getFrequency(String[] wordlist, String word) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String w : wordlist) {
            if (map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            }
            else {
                map.put(w, 1); 
           }
        }
        if ( !map.containsKey(word)) {
            return 0;
        }
        return map.get(word);
    }
    
    public static void main(String[] args) {
        String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();

        String[] words = {"the", "Lara", "and", "outcropping", "career", "it"};
        for (String word : words) {
            System.out.println(word + ": " + getFrequency(wordlist, word));
        }
    }
}
