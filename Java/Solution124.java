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
class Solution124 {
    public int maxPathSum(TreeNode root) {
        // 构建一个全局最大值
        int[] res = new int[1];
        return maxsum(root, res);
    }

    public int maxsum(TreeNode root, int[] res){
        int left = 0, right =0;
        if (root.left == null && root.right == null) return root.val;
        // 计算左孩子为起始结点的最大路径和
        if (root.left != null) left = maxPathSum(root.left);
        // 计算右孩子为起始结点的最大路径和
        if (root.right != null) right = maxPathSum(root.right);
        res[0] = Math.max(left + right + root.val, res[0]);
        return Math.max(left, right);
    }
}