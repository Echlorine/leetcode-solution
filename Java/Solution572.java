/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution572 {
    private boolean flag;
    private Set<String> set;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        flag = false;
        set = new HashSet<>();
        setpreorder(root);
        if (set.contains(preorder(subRoot))) flag = true;
        return flag;
    }

    public String preorder(TreeNode root) {
        if (root == null) return "#";
        String res = String.valueOf(root.val) + preorder(root.left) + preorder(root.right);
        return res;
    }

    public String setpreorder(TreeNode root) {
        if (root == null) return "#";
        String res = String.valueOf(root.val) + setpreorder(root.left) + setpreorder(root.right);
        set.add(res);
        return res;
    }
}