/*
 *  Cracking the Coding Interview Solutions.
 */

package Q01_06_String_Compression;

/**
 *
 * @author cesar_magana
 */
public class Solution01 {
    
    public static String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        char ch = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != ch || i == str.length() - 1) {
                compressed.append(str.charAt(i - 1));
                compressed.append(count);
                count = 1;
                ch = str.charAt(i);
            }
            else {
                count++;
            }
        }
    String com = compressed.toString();
    return com.length() > str.length() ? str : com;
    }
    
    public static void main(String[] args) {
        System.out.println(compress("abcaaabbb"));
        System.out.println(compress("abcd"));
        System.out.println(compress("aaabaaaaccaaaaba"));
        System.out.println(compress("aaaaaabbbbbcdddddddd"));
    }
}

/*
for (int i = 0; i < n; i++) {
char ch = phrase.charAt(i);
if (stack.isEmpty()) {
if (ch == '(') {
stack.add(ch);
}
output.append(ch);
}
stack.

}*/


//String output = phrase.substring(0,3) + reverse(phrase.substring(4,7)) + phrase.substring(8,n);
//String output = phrase.substring(0,3) + reverse(phrase.substring(4,7)) + phrase.substring(8,n);
