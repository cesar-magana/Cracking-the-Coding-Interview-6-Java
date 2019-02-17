/*
 *  Cracking the Coding Interview Solutions.
 */
package Q03_02_Stack_Min;

import java.util.Stack;

/**
 *
 * @author cesar_magana
 */
public class StackWithMax extends Stack<Integer> {

    Stack<Integer> smax;

    public StackWithMax() {
        smax = new Stack<Integer>();
    }

    public void push(int value) {
        super.push(value);
        if (value >= max()) {
            smax.push(value);
        }
    }

    public Integer pop() {
        int value = super.pop();
        if (value == max()) {
            smax.pop();
        }
        return value;
    }

    public int max() {
        if (smax.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return smax.peek();
    }

    public static void main (String[] args) {
        StackWithMax sm = new StackWithMax();
        sm.push(0);
        sm.push(1);
        sm.push(6);
        sm.push(2);
        sm.push(7);
        sm.push(8);
        sm.push(10);
        sm.push(3);
        System.out.println("MAX " + sm.max());
        System.out.println("POP " + sm.pop());
        System.out.println("POP " + sm.pop());
        System.out.println("POP " + sm.pop());
        System.out.println("MAX " + sm.max());
        System.out.println("POP " + sm.pop());
        System.out.println("MAX " + sm.max());
        System.out.println("POP " + sm.pop());
        System.out.println("MAX " + sm.max());
    }    
    
}
