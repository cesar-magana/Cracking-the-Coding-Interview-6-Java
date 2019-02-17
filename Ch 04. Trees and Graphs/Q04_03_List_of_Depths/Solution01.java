package Q04_03_List_of_Depths;

import static Q04_03_List_of_Depths.TreeNode.levelOrder;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 *  Cracking the Coding Interview Solutions.
 */
/**
 *
 * @author cesar_magana
 */
public class Solution01 {

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

        /* "Visit" the root */
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0) {
            result.add(current); // Add previous level
            LinkedList<TreeNode> parents = current; // Go to next level
            current = new LinkedList<TreeNode>();
            for (TreeNode parent : parents) {
                /* Visit the children */
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode root = TreeNode.createMinBST(array);
        System.out.println("Root? " + root.data);
        System.out.println("Created BST? " + root.isBST());
        System.out.println("Height: " + root.height());
        System.out.print("Print: ");
        levelOrder(root);
        System.out.println("List ");
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
        int i = 0;
        for (LinkedList<TreeNode> level : list) {
            i++;
            System.out.printf("Level %d: ", i);
            while (!level.isEmpty()) {
                System.out.printf("%d ", level.poll().data);
            }
            System.out.println("");
        }
    }
}
