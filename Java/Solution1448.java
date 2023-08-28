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
class Solution1448 {
    private int res;

    public int goodNodes(TreeNode root) {
        res = 0;
        dfs(root, Integer.MIN_VALUE);
        return res;
    }

    public void dfs(TreeNode root, int val) {
        if (root == null) return;
        if (root.val >= val) res++;
        int t = Math.max(root.val, val);
        dfs(root.left, t);
        dfs(root.right, t);
    }
}