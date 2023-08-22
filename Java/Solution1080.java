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
class Solution1080 {
    private int limit;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        Map<TreeNode, Integer> map = new HashMap<>();
        postOrder(root, map);
        return preOrder(root, 0, map);
    }

    public int postOrder(TreeNode root, Map<TreeNode, Integer> map) {
        int sum = Integer.MIN_VALUE;
        // 遍历左节点
        if (root.left != null) {
            int left = postOrder(root.left, map);
            sum = Math.max(sum, left + root.val);
        }
        // 遍历右节点
        if (root.right != null) {
            int right = postOrder(root.right, map);
            sum = Math.max(sum, right + root.val);
        }
        // 遍历当前节点
        if (sum == Integer.MIN_VALUE) sum = root.val;
        map.put(root, sum);
        return sum;
    }

    public TreeNode preOrder(TreeNode root, int curSum, Map<TreeNode, Integer> map) {
        if (root == null) return null;
        if (curSum + map.get(root) < limit) {
            return null;
        }
        root.left = preOrder(root.left, curSum + root.val, map);
        root.right = preOrder(root.right, curSum + root.val, map);
        return root;
    }
}

class Solution {
    private int limit;
    
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        return dfs(root, 0) ? root : null;
    }

    public boolean dfs(TreeNode root, int curSum) {
        boolean left = false, right = false;
        if (root.left != null) left = dfs(root.left, curSum + root.val);
        if (root.right != null) right = dfs(root.right, curSum + root.val);
        boolean flag = false;
        if (root.left == null && root.right == null) flag = true;
        if (!left) root.left = null;
        if (!right) root.right = null;
        if (flag) return curSum + root.val >= limit;
        return left || right;
    }
}