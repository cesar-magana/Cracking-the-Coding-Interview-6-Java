/*
 *  Cracking the Coding Interview Solutions.
 */
package Q02_07_Intersection;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

/**
 *
 * @author cesar_magana
 */
public class Solution02 {

    public static int countNodes(LinkedListNode node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    } 
    
    public static LinkedListNode removeFirstKth(LinkedListNode node, int k) {
        for (int i = 0; i < k; i++) {
            node = node.next;
        }
        return node;
    }
    
    public static LinkedListNode findIntersection(LinkedListNode one, LinkedListNode two) {
        int count1 = countNodes(one);
        int count2 = countNodes(two);
        int skip = Math.abs(count1 - count2);
        if (count1 > count2) {
            one = removeFirstKth(one, skip);
        } else {
            two = removeFirstKth(two, skip);
        }
        while (one != null) {
            if (one == two) {
                return one;
            }
            one = one.next;
            two = two.next;
        }
        return null;
    }

    public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);

        int[] vals2 = {12, 14, 15};
        LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);

        list2.next.next = list1.next.next.next.next;

        System.out.println(list1.printForward());
        System.out.println(list2.printForward());

        LinkedListNode intersection = findIntersection(list1, list2);

        System.out.println(intersection.printForward());
    }
}
