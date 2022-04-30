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

class Solution99 {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(root != null) {
            stack.addLast(root);
            root = root.left;
        }
        int lastvalue = Integer.MIN_VALUE;
        List<TreeNode> node = new ArrayList<>();
        TreeNode lastreenode = new TreeNode(), p = new TreeNode();
        while (stack.size() != 0) {
            p = stack.removeLast();
            int value = p.val;
            if (value < lastvalue) {
                node.add(lastreenode);
                node.add(p);
            }
            TreeNode temp = p.right;
            while (temp != null) {
                stack.addLast(temp);
                temp = temp.left;
            }
            lastvalue = value;
            lastreenode = p;
        }
        int temp = node.get(0).val;
        node.get(0).val = node.get(node.size() - 1).val;
        node.get(node.size() - 1).val = temp;
    }
}