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
class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        TreeNode p;
        if (root == null) return root; // 特例
        // 生成根节点
        p = new TreeNode(root.val);
        // 生成左子树
        if (root.right != null) p.left = invertTree(root.right);
        // 生成右子树
        if (root.left != null) p.right = invertTree(root.left);
        return p;
    }
}