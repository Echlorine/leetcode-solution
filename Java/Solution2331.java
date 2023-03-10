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
class Solution2331 {
    public boolean evaluateTree(TreeNode root) {
        dfs(root);
        return root.val == 1;
    }

    public int dfs(TreeNode root) {
        if (root.left == null || root.right == null) return root.val;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (root.val == 2) root.val = l | r;
        else root.val = l & r;
        root.left = null;
        root.right = null;
        return root.val;
    }
}