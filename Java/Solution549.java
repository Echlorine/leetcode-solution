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
class Solution549 {
    private int res;

    public int longestConsecutive(TreeNode root) {
        res = 1;
        postpoder(root);
        return res;
    }

    public int[] postpoder(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int dp = 1, ip = 1; // 以当前结点为根的递减和递增
        // 左孩子
        int[] lres = postpoder(root.left);
        if (root.left != null && root.val != root.left.val - 1) dp = Math.max(dp, 1);
        else dp = Math.max(dp, lres[0] + 1);
        if (root.left != null && root.val != root.left.val + 1) ip = Math.max(ip, 1);
        else ip = Math.max(ip, lres[1] + 1);
        // 右孩子
        int[] rres = postpoder(root.right);
        if (root.right != null && root.val != root.right.val - 1) dp = Math.max(dp, 1);
        else dp = Math.max(dp, rres[0] + 1);
        if (root.right != null && root.val != root.right.val + 1) ip = Math.max(ip, 1);
        else ip = Math.max(ip, rres[1] + 1);
        // 自身
        res = Math.max(res, dp + ip - 1);
        return new int[] {dp, ip};
    }
}