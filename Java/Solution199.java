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

class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> depth = new ArrayDeque<>();
        int maxdepth = -1;
        // 根节点入栈
        stack.offerLast(root);
        depth.offerLast(0);
        // 先跟遍历
        while (!stack.isEmpty()) {
            TreeNode treetemp = stack.removeLast();
            int tempdepth = depth.removeLast();
            if (tempdepth > maxdepth) {
                maxdepth = tempdepth;
                res.add(treetemp.val);
            }
            if (treetemp.left != null) {
                stack.offerLast(treetemp.left);
                depth.offerLast(tempdepth + 1);
            }
            if (treetemp.right != null) {
                stack.offerLast(treetemp.right);
                depth.offerLast(tempdepth + 1);
            }
        }
        return res;
    }
}