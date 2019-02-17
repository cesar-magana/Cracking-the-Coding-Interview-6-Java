/*
 *  Cracking the Coding Interview Solutions.
 */
package Q02_03_Delete_Middle_Node;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

/**
 *
 * @author cesar_magana
 */
public class Solution01 {

    public static boolean deleteNode(LinkedListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        LinkedListNode next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
    }

    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        deleteNode(head.next.next.next.next); // delete node 4
        System.out.println(head.printForward());
    }
}
