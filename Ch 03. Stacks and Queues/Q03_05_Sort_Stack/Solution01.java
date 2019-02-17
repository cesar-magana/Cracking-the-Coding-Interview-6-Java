/*
 *  Cracking the Coding Interview Solutions.
 */
package Q03_05_Sort_Stack;

import CtCILibrary.AssortedMethods;
import java.util.Stack;

/**
 *
 * @author cesar_magana
 */
public class Solution01 {

    public static Stack<Integer> sort(Stack<Integer> stack1) {
        Stack<Integer> stack2 = new Stack<Integer>();
        while (!stack1.isEmpty()) {
            int element = stack1.pop();
            while (!stack2.isEmpty() && element > stack2.peek()) {
                stack1.push(stack2.pop());
            }
            stack2.push(element);
        }
        return stack2;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            int r = AssortedMethods.randomIntInRange(0, 1000);
            s.push(r);
        }

        Stack<Integer> r = sort(s);

        while (!r.isEmpty()) {
            System.out.println(r.pop());
        }
    }
}
