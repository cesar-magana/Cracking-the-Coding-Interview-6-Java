/*
 *  Cracking the Coding Interview Solutions.
 */
package Q04_06_Successor;

import CtCILibrary.TreeNode;

/**
 *
 * @author cesar_magana
 */
public class Solution01 {

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.printf("%d ", root.data);
            inOrder(root.right);
        }
    }

    public static TreeNode inorderSucc(TreeNode root, TreeNode node) {
        if (node.right != null) {
            return minValue(node.right);
        }
        TreeNode succ = null;
        while (root != null) {
            if (node.data < root.data) {
                succ = root;
                root = root.left;
            } else if (node.data > root.data) {
                root = root.right;
            } else {
                break;
            }
        }
        return succ;
    }
    
    public static TreeNode minValue(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);

        root.print();
        inOrder(root);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            TreeNode node = root.find(array[i]);
            TreeNode next = inorderSucc(root, node);
            if (next != null) {
                System.out.println(node.data + "->" + next.data);
            } else {
                System.out.println(node.data + "->" + null);
            }
        }
    }

}
