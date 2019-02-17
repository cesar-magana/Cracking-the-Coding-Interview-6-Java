package Q03_02_Stack_Min;


import java.util.Stack;

/*
 *  Cracking the Coding Interview Solutions.
 */
/**
 *
 * @author cesar_magana
 */
public class StackWithMin2 extends Stack<Integer> {

    Stack<Integer> stack2;

    public StackWithMin2() {
        stack2 = new Stack<Integer>();
    }

    public void push(int value) {
        super.push(value);
        if (value <= min()) {
            stack2.push(value);
        }
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            stack2.pop();
        }
        return value;
    }

    public int min() {
        if (stack2.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return stack2.peek();
    }
    
    public static void main (String[] args) {
        StackWithMin2 sm = new StackWithMin2();
        sm.push(5);
        sm.push(5);
        sm.push(1);
        sm.push(2);
        sm.push(4);
       
        System.out.println("MIN " + sm.min());
        System.out.println("POP " + sm.pop());
        System.out.println("POP " + sm.pop());
        System.out.println("POP " + sm.pop());
        System.out.println("MIN " + sm.min());
        System.out.println("POP " + sm.pop());
        System.out.println("MIN " + sm.min());
    }
    
}
