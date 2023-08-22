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
class Solution1120 {
    private double res;
    
    public double maximumAverageSubtree(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        dfs(root, map);
        return res;
    }

    public int dfs(TreeNode root, Map<TreeNode, Integer> map) {
        int left = 0, right = 0;
        int lNum = 0, rNum = 0;
        if (root.left != null) {
            left = dfs(root.left, map);
            lNum = map.get(root.left);
        }
        if (root.right != null) {
            right = dfs(root.right, map);
            rNum = map.get(root.right);
        }
        map.put(root, lNum + rNum + 1);
        int sum = root.val + left + right;
        res = Math.max(res, 1.0 * sum / map.get(root));
        return sum;
    }
}