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
class Solution687 {
    private int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        postorder(root);
        return res;
    }

    public int postorder(TreeNode root) {
        if (root == null) return 0;
        // 左孩子
        int vleft = postorder(root.left);
        if (root.left != null && root.val != root.left.val) vleft = 0;
        else if (root.left == null) vleft = 0;
        else vleft++;
        // 右孩子
        int vright = postorder(root.right);
        if (root.right != null && root.val != root.right.val) vright = 0;
        else if (root.right == null) vright = 0;
        else vright++;
        res = Math.max(res, vleft + vright);
        return Math.max(vleft, vright);
    }
}