/*
 *  Cracking the Coding Interview Solutions.
 */
package Q04_04_Check_Balanced;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

/**
 *
 * @author cesar_magana
 */
public class Solution02 {

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.abs(left - right) < 2;
    }

    public static void main(String[] args) {
        // Create balanced tree
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("Root? " + root.data);
        root.print();
        System.out.println("Is balanced? " + isBalanced(root));

        // Could be balanced, actually, but it's very unlikely...
        TreeNode unbalanced = new TreeNode(10);
        for (int i = 0; i < 10; i++) {
            unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
        }
        System.out.println("Root? " + unbalanced.data);
        unbalanced.print();
        System.out.println("Is balanced? " + isBalanced(unbalanced));
    }
}
