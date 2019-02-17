/*
 *  Copyright 2016 @cesar_magana
 */
package Q02_05_Sum_Lists;

import CtCILibrary.LinkedListNode;

/**
 * @author cesar
 */
public class Solution01 {

    private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode result = null;
        LinkedListNode prev = null;
        LinkedListNode temp = null;
        int carry = 0;

        int sum = 0;
        while (l1 != null || l2 != null) {
            sum = (l1 != null ? l1.data : 0) + (l2 != null ? l2.data : 0) + carry;
            carry = (sum > 9 ? 1 : 0);
            sum = sum % 10;

            temp = new LinkedListNode(sum, null, prev);
            if (result == null) {
                result = temp;
            } else {
                prev.next = temp;
            }

            prev = temp;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            temp.next = new LinkedListNode(carry, null, prev);
        }
        return result;
    }

    public static int linkedListToInt(LinkedListNode node) {
        int value = 0;
        if (node.next != null) {
            value = 10 * linkedListToInt(node.next);
        }
        return value + node.data;
    }

    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(9, null, null);
        LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(9, null, lA2);
        LinkedListNode lA4 = new LinkedListNode(9, null, lA3);

        LinkedListNode lB1 = new LinkedListNode(1, null, null);
        LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(9, null, lB2);

        LinkedListNode list3 = addLists(lA1, lB1);

        System.out.println("  " + lA1.printForward());
        System.out.println("+ " + lB1.printForward());
        System.out.println("= " + list3.printForward());

        int l1 = linkedListToInt(lA1);
        int l2 = linkedListToInt(lB1);
        int l3 = linkedListToInt(list3);

        System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
        System.out.print(l1 + " + " + l2 + " = " + (l1 + l2) + "\n");
    }

}
