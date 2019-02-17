/*
 *  Cracking the Coding Interview Solutions.
 */
package Q02_07_Intersection;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;
import java.util.HashSet;

/**
 *
 * @author cesar_magana
 */
public class Solution01 {

    public static LinkedListNode findIntersection(LinkedListNode one, LinkedListNode two) {
        HashSet<LinkedListNode> set = new HashSet<LinkedListNode>();

        while (one != null) {
            set.add(one);
            one = one.next;
        }

        while (two != null) {
            if (set.contains(two)) {
                return two;
            }
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
