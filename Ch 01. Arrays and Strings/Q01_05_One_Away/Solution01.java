/*
 *  Cracking the Coding Interview Solutions.
 */

package Q01_05_One_Away;

/**
 * One Away: There are three types of edits that can be performed on strings: 
 * insert a character, remove a character, or replace a character. Given two 
 * strings, write a function to check if they are one edit (or zero edits) away. 
 * @author cesar_magana
 */
public class Solution01 {

    public static boolean oneEditRemove (String a, String b) {
        return oneEditInsert(b,a);
    }
    
    public static boolean oneEditInsert (String a, String b) {
        boolean changes = false;
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) != b.charAt(j)) {
                if (changes == true) {
                    return false;
                }
                changes = true;
                i++;
            }
            i++;
            j++;
        }
        return true;
    }
    
    public static boolean oneEditReplace (String a, String b) {
        int replaces = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                replaces++;
            }
        }
        return replaces <= 1;
    }
    
    public static boolean oneEditAway(String a, String b) {
        if (a.length() == b.length()) {
            return oneEditReplace(a,b);
        } else if (a.length() == b.length() + 1) {
            return oneEditInsert(a,b); 
        } else if (a.length() + 1 == b.length()) {
            return oneEditRemove(a,b);
        }
    return false;
    }
    
    public static void main(String[] args) {
        String a = "1234567890";
        String b = "1234567890";
        System.out.println(a + ", " + b + ": " + oneEditAway(a, b));
        a = "abcdefg";
        b = "abccefg";
        System.out.println(a + ", " + b + ": " + oneEditAway(a, b));
        a = "abcdefg";
        b = "ebcdefg";
        System.out.println(a + ", " + b + ": " + oneEditAway(a, b));
        a = "abcdefr";
        b = "abcdefg";
        System.out.println(a + ", " + b + ": " + oneEditAway(a, b));
        a = "vwxyz";
        b = "vxyz";
        System.out.println(a + ", " + b + ": " + oneEditAway(a, b));
        a = "vwxyz";
        b = "wxyz";
        System.out.println(a + ", " + b + ": " + oneEditAway(a, b));
        a = "vwxyz";
        b = "vwxy";
        System.out.println(a + ", " + b + ": " + oneEditAway(a, b));
        a = "abcDefghijklmnopQrstuvwxyz";
        b = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(a + ", " + b + ": " + oneEditAway(a, b));
        a = "abcdefghijklmnopqrstuvwxyz";
        b = "zbcdefghijklmnopqrstuvwxya";
        System.out.println(a + ", " + b + ": " + oneEditAway(a, b));
        a = "abcdefghijklmnopqrstuvxyz";
        b = "abcdfghijklmnopqrstuvwxyz";
        System.out.println(a + ", " + b + ": " + oneEditAway(a, b));
        a = "abcdefghijklmnopqrstuvwxyz";
        b = "abcefghijklmnopqrstuvxyz";
        System.out.println(a + ", " + b + ": " + oneEditAway(a, b));        
    }
}
