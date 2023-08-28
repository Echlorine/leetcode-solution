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
class Solution270 {
    private int res;
    private double diff;

    public int closestValue(TreeNode root, double target) {
        diff = Math.abs(root.val - target);
        res = root.val;
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode root, double target) {
        if (root == null) return;
        double d = Math.abs(root.val - target);
        if (d < diff) {
            diff = d;
            res = root.val;
        } else if (d == diff) {
            res = Math.min(res, root.val);
        }
        dfs(root.left, target);
        dfs(root.right, target);
    }

    public void dfs(TreeNode root, double target) {
        if (root == null) return;
        double d = Math.abs(root.val - target);
        if (d < diff) {
            diff = d;
            res = root.val;
        } else if (d == diff) {
            res = Math.min(res, root.val);
        } 
        if (root.val < target) dfs(root.right, target);
        else dfs(root.left, target);
    }
}