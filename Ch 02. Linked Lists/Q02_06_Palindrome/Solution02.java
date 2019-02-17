/*
 *  Cracking the Coding Interview Solutions.
 */
package Q02_06_Palindrome;

import CtCILibrary.LinkedListNode;

/**
 *
 * @author cesar_magana
 */
public class Solution02 {

    public static LinkedListNode cloneAndReverseLinkedList(LinkedListNode head) {
        LinkedListNode previous = null;
        while (head != null) {
            LinkedListNode current = new LinkedListNode(head.data,previous,null);
            //current.next = previous;
            previous = current;
            head = head.next;
        }
        return previous;
    }

    public static boolean isEqual(LinkedListNode head1, LinkedListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }

    public static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode reversed = cloneAndReverseLinkedList(head);
        return isEqual(head, reversed);
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
        nodes[length - 2].data = 9; // Uncomment to ruin palindrome

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());
        System.out.println(isPalindrome(head));
        //LinkedListNode tail = cloneAndReverseLinkedList(head);
        //System.out.println(tail.printForward());
    }
}
