/*
 *  Cracking the Coding Interview Solutions.
 */

package Q01_03_URLify;

/**
 * URLify: Write a method to replace all spaces in a string with '%20: You may 
 * assume that the string has sufficient space at the end to hold the additional 
 * characters, and that you are given the "true" length of the string. 
 * (Note: if implementing in Java, please use a character array so that you can 
 * perform this operation in place.)
 * @author cesar_magana
 */
public class Question {
    
    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                    return i;
            }
        }
        return -1;
    }
    
    public static void replaceSpaces(char[] input, int trueLength) {
        int j = input.length - 1;
        for (int i = trueLength - 1; i > 0; i--) {
            if (input[i] == ' ') {
                input[j--] = '0';
                input[j--] = '2';
                input[j--] = '%';
            }
            else {
                input[j--] = input[i];
            }
        }
    }
    
    public static void replaceSpaces2(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            }
            else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }
 
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = findLastCharacter(arr) + 1;
        replaceSpaces2(arr, trueLength);	
        System.out.println(arr);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Execution time: " + duration + " ms");                
    }
}
