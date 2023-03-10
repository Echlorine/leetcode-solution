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
class Solution110 {
    public boolean flag;
    
    public boolean isBalanced(TreeNode root) {
        flag = true;
        dfs(root);
        return flag;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (Math.abs(l - r) > 1) flag = false;
        return Math.max(l, r) + 1;
    }
}