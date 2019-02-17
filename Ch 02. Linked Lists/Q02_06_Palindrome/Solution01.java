/*
 *  Cracking the Coding Interview Solutions.
 */
package Q02_06_Palindrome;

import CtCILibrary.LinkedListNode;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;
import java.util.Stack;

/**
 *
 * @author cesar_magana
 */
public class Solution01 {
    
    public static boolean isPalindrome(LinkedListNode head) {
        int length = 0;
        LinkedListNode aux = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (aux != null) {
            length++;
            aux = aux.next;
        }
        boolean odd = (length%2 == 1);
        int n = 0;
        while (n < length/2) {
            stack.add(head.data);
            head = head.next;
            n++;
        }
        if (odd == true) {
            n++;
            head = head.next;
        }
        while (n < length) {
            if (stack.pop() != head.data) {
                return false;
            }
            head = head.next;
            n++;
        }
        return true;
    }

    public static void main(String[] args) {
        int length = 10;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
        }

        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
            if (i > 0) {
                nodes[i].setPrevious(nodes[i - 1]);
            }
        }
        //nodes[length - 2].data = 9; // Uncomment to ruin palindrome

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());
        System.out.println(isPalindrome(head));
    }
}
