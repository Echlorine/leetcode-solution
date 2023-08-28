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
class Solution1373 {
    private int res;
    
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return res;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[] {-1, 0, 0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        boolean l = left[0] == -1 || (left[0] == 1 && left[2] < root.val);
        int min = left[0] == -1 ? root.val : left[1];
        boolean r = right[0] == -1 || (right[0] == 1 && right[1] > root.val);
        int max = right[0] == -1 ? root.val : right[2];
        int sum = left[3] + right[3] + root.val;
        if (l && r) {
            res = Math.max(res, sum);
            return new int[]{1, min, max, sum};
        }
        return new int[] {0, -1, -1, sum};
    }
}