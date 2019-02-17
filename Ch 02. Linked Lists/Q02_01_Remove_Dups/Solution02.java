/*
 *  Cracking the Coding Interview Solutions.
 */

package Q02_01_Remove_Dups;

import CtCILibrary.LinkedListNode;
import java.util.HashSet;

/**
 *
 * @author cesar_magana
 */
public class Solution02 {
    public static void deleteDups(LinkedListNode head) {
        // Time O(N^2)
        while (head != null) {
            LinkedListNode runner = head;
            while (runner.next != null) {
                if (runner.next.data == head.data) {
                    runner.next = runner.next.next;
                }
                else {
                    runner = runner.next;
                }
            }
            head = head.next;
        }
    }
    
    public static void main(String[] args) {	
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 20; i++) {
            second = new LinkedListNode(i % 10, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        deleteDups(head);
        System.out.println(head.printForward());
    }
}
