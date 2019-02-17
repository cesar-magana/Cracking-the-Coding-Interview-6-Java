/*
 *  Cracking the Coding Interview Solutions.
 */

package Q02_02_Return_Kth_To_Last;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

/**
 *
 * @author cesar_magana
 */
public class Solution01 {
    
    public static LinkedListNode nthToLast(LinkedListNode head, int k) {
        LinkedListNode node1 = head;
        LinkedListNode node2 = head;
        for (int i = 0; i < k+1; i++) {
            if(node1 == null) return null;
            node1 = node1.next;
        }
        while (node1 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;
    }
    
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        for (int i = 0; i < array.length; i++) {
            LinkedListNode node = nthToLast(head, i);
            String nodeValue = node == null ? "null" : "" + node.data;
            System.out.println(i + ": " + nodeValue);
        }
    }
}
