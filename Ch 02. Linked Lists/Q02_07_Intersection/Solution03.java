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
public class Solution03 {

    public static LinkedListNode findIntersection(LinkedListNode one, LinkedListNode two) {
        LinkedListNode checker = one;
        while (checker != null) {
            LinkedListNode pointer = two;
            while (pointer != null) {
                if (pointer == checker) {
                    return pointer;
                }
                pointer = pointer.next;
            }
            checker = checker.next;
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
