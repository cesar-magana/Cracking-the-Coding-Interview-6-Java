package MyClasses;

/*
 *  Cracking the Coding Interview Solutions.
 */

/**
 *
 * @author cesar_magana
 */
public class MyStack<Item> {

    private Item[] a = (Item[])new Object[100];
    private int top = -1;
    
    public void push(Item x) {
        a[++top] = x;
    }
    
    public Item pop() {
        return a[top--];
    }
    
    public Item peek() {
        return a[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<String>();
        stack.push("A");
        stack.push("12");
        stack.push("Hola");
        stack.push("7");
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
    
}
