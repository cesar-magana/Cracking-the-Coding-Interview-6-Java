/*
 *  Cracking the Coding Interview Solutions.
 */
package Q04_03_List_of_Depths;

import static Q04_03_List_of_Depths.TreeNode.levelOrder;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author cesar_magana
 */
public class Solution02 {
    
    public static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;
        LinkedList<TreeNode> list = null;
        if (lists.size() == level) {
            list = new LinkedList<TreeNode>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode root = TreeNode.createMinBST(array);
        System.out.println("Root? " + root.data);
        System.out.println("Created BST? " + root.isBST());
        System.out.println("Height: " + root.height());
        System.out.print("Print: ");
        levelOrder(root);
        System.out.println("\nList ");
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
