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
class Solution250 {
    private int res;

    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        postorder(root);
        return res;
    }

    public boolean postorder(TreeNode root) {
        if (root == null) return true;
        boolean flag = true;
        // 左孩子
        boolean bleft = postorder(root.left);
        if (root.left != null && root.val != root.left.val) flag = false;
        else flag = bleft && flag;
        // 右孩子
        boolean bright = postorder(root.right);
        if (root.right != null && root.val != root.right.val) flag = false;
        else flag = bright && flag;
        if (flag) res++;
        return flag;
    }
}