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
public class Solution01 {

    public static void deleteDups(LinkedListNode head) {
        // Complexity: O(N)
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = null;
        while (head != null) {
            if (set.contains(head.data)) {
                previous.next = head.next;
            }
            else {
                set.add(head.data);
                    previous = head;
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
