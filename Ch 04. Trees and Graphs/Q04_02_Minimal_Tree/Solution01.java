/*
 *  Cracking the Coding Interview Solutions.
 */
package Q04_02_Minimal_Tree;

import static Q04_02_Minimal_Tree.TreeNode.levelOrder;

/**
 *
 * @author cesar_magana
 */
public class Solution01 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode root = TreeNode.createMinBST(array);
        System.out.println("Root? " + root.data);
        System.out.println("Created BST? " + root.isBST());
        System.out.println("Height: " + root.height());
        System.out.print("Print: ");
        levelOrder(root);
    }
}
