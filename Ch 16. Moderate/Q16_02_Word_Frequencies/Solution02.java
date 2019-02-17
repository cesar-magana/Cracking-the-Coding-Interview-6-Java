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
public class Solution02 {
    
    public static int getFrequency (HashMap<String, Integer> dictionary, String word) {
        if (!dictionary.containsKey(word)) return 0;
        return dictionary.get(word);
    }

    public static HashMap<String, Integer> setupDictionary(String[] wordlist) {
        HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
        for (String w : wordlist) {
            if (dictionary.containsKey(w)) {
                dictionary.put(w, dictionary.get(w) + 1);
            }
            else {
                dictionary.put(w, 1);
            }
        }
        return dictionary;
    }
    
    public static void main(String[] args) {
        String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
        HashMap<String, Integer> dictionary = setupDictionary(wordlist);

        String[] words = {"the", "Lara", "and", "outcropping", "career", "it"};
        for (String word : words) {
            System.out.println(word + ": " + getFrequency(dictionary, word));
        }
    }
}
