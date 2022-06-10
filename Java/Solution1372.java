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
class Solution1372 {
    private int res;

    public int longestZigZag(TreeNode root) {
        res = 0;
        postorder(root);
        return res;
    }

    public int[] postorder(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int lp = 0, rp = 0;
        // 左孩子
        int[] lorder = postorder(root.left);
        int[] rorder = postorder(root.right);
        lp = rorder[1] + 1;
        rp = lorder[0] + 1;
        res = Math.max(res, Math.max(lp, rp) - 1);
        return new int[] {lp, rp};
    }
}