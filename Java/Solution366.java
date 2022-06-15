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

class Solution366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Map<TreeNode, Boolean> map = new HashMap<>();
        TreeNode node = root;
        while (node != null && !map.getOrDefault(node, false)) {
            Deque<TreeNode> stack = new ArrayDeque<>(); // 初始化栈
            stack.offerLast(node);
            List<Integer> ans = new LinkedList<>();
            while (!stack.isEmpty()) {
                TreeNode temp = stack.pollLast();
                if ((temp.right == null || map.getOrDefault(temp.right, false)) &&
                    (temp.left == null || map.getOrDefault(temp.left, false))) {
                    ans.add(temp.val);
                    map.put(temp, true);
                }
                else {
                    if (temp.right != null && !map.getOrDefault(temp.right, false)) stack.offerLast(temp.right);
                    if (temp.left != null && !map.getOrDefault(temp.left, false)) stack.offerLast(temp.left);
                }                
            }
            res.add(ans);
        }
        return res;
    }
}