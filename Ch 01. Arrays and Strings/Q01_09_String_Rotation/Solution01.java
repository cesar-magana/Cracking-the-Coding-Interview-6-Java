/*
 *  Cracking the Coding Interview Solutions.
 */

package Q01_09_String_Rotation;

/**
 *
 * @author cesar_magana
 */
public class Solution01 {

    public static boolean isSubstring(String big, String small) {
        if (big.indexOf(small) >= 0) {
                return true;
        } else {
                return false;
        }
    }    
    public static boolean isRotation(String x, String y) {
        if (x.length() != y.length()) return false;
        String yy = y + y;
        return isSubstring(yy,x);
    }
    
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
                String word1 = pair[0];
                String word2 = pair[1];
                boolean is_rotation = isRotation(word1, word2);
                System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}
