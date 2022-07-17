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
class Solution865 {
    private int maxDepth;
    private TreeNode res;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        maxDepth = Integer.MIN_VALUE;
        postOrder(root, 0);
        return res;
    }

    public int postOrder(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int leftDepth = postOrder(root.left, depth + 1);
        int rightDepth = postOrder(root.right, depth + 1);
        int currentMax = Math.max(leftDepth, rightDepth);
        maxDepth = Math.max(maxDepth, currentMax);
        if (leftDepth == maxDepth && rightDepth == maxDepth) {
            res = root;
        }
        return currentMax;
    }
}

class Solution1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int ld = depth(root.left);
        int rd = depth(root.right);
        if (ld == rd) {
            return root;
        } else if (ld < rd) {
            return lcaDeepestLeaves(root.right);
        } else {
            return lcaDeepestLeaves(root.left);
        }
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        int ld = depth(root.left);
        int rd = depth(root.right);
        return Math.max(ld, rd) + 1;
    }
}