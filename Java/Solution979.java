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
class Solution979 {
    private int res = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        int left = 0, right = 0;
        // 左孩子
        if (root.left != null) {
            left = dfs(root.left);
        }
        // 右孩子
        if (root.right != null) {
            right = dfs(root.right);
        }
        // 确定以 root 为根的节点的数量、数值和
        res += Math.abs(left + right + root.val - 1);
        return left + right + root.val - 1;
    }
}