/*
 *  Cracking the Coding Interview Solutions.
 */
package Q04_02_Minimal_Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author cesar_magana
 */
public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    private int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    private void setLeftChild(TreeNode left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    private void setRightChild(TreeNode right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                setLeftChild(new TreeNode(d));
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                setRightChild(new TreeNode(d));
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isBST() {
        if (left != null) {
            if (data < left.data || !left.isBST()) {
                return false;
            }
        }

        if (right != null) {
            if (data >= right.data || !right.isBST()) {
                return false;
            }
        }

        return true;
    }

    public int height() {
        int leftHeight = left != null ? left.height() : 0;
        int rightHeight = right != null ? right.height() : 0;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public TreeNode find(int d) {
        if (d == data) {
            return this;
        } else if (d <= data) {
            return left != null ? left.find(d) : null;
        } else if (d > data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }

    private static TreeNode createMinimalBST(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = createMinimalBST(arr, start, mid - 1);
        node.right = createMinimalBST(arr, mid + 1, end);
        return node;
    }

    public static TreeNode createMinBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.printf("%d ", root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.printf("%d ", node.data);
            if (node.left != null) {
                levelOrder(node.left);
            }
            if (node.right != null) {
                levelOrder(node.right);
            }
        }
    }
}
