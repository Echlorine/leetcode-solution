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
class Solution298 {
    private int res;

    public int longestConsecutive(TreeNode root) {
        res = 1;
        postorder(root);
        return res;
    }

    public int postorder(TreeNode root) {
        if (root == null) return 0;
        int left = 0, right = 0;
        if (root.left != null && root.val != root.left.val - 1) {
            left = 1;
            postorder(root.left);
        }
        else left = postorder(root.left) + 1;
        if (root.right != null && root.val != root.right.val - 1) {
            right = 1;
            postorder(root.right);
        }
        else right = postorder(root.right) + 1;
        int temp = Math.max(left, right);
        res = Math.max(res, temp);
        return temp;
    }
}