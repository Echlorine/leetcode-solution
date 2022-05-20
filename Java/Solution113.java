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

class Solution113 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        dfs(root, targetSum);
        return res;
    }

    public void dfs(TreeNode root, int target) {
        if (root.left == null && root.right == null && root.val == target) {
            ans.add(root.val);
            res.add(new ArrayList<Integer>(ans));
            ans.remove(ans.size() - 1);
            return;
        }
        // 访问当前结点
        ans.add(root.val);
        if (root.left != null) dfs(root.left, target - root.val);
        // 回溯
        if (root.right != null) dfs(root.right, target - root.val);
        ans.remove(ans.size() - 1);
    }
}