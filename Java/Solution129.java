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
class Solution129 {

    private int res = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int last) {
        if (root.left == null && root.right == null) {
            res += last * 10 + root.val;
            return;
        }
        if (root.left != null) dfs(root.left, last * 10 + root.val);
        if (root.right != null) dfs(root.right, last * 10 + root.val);
    }
}