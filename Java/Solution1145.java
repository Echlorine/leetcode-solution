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
class Solution1145 {
    public int n, x, x_left, x_right, x_parent;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.n = n;
        this.x = x;
        getNum(root);
        return Math.max(Math.max(x_left, x_right), x_parent) > n / 2;
    }

    public int getNum(TreeNode root) {
        if (root == null) return 0;
        int ld = getNum(root.left);
        int rd = getNum(root.right);
        if (root.val == this.x) {
            x_left = ld;
            x_right = rd;
            x_parent = n - 1 - ld - rd;
        }
        return ld + rd + 1;
    }
}