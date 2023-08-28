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
class Solution669 {
    private int min_num;
    private int max_num;
    
    public TreeNode trimBST(TreeNode root, int low, int high) {
        min_num = low - 1;
        max_num = high + 1;
        inorder(root);
        TreeNode res = new TreeNode(root.val, root.left, root.right);
        return res;
    }

    public void inorder(TreeNode root, TreeNode res) {
        if (root == null) return;
        // 访问左子树
        inorder(root.left, res.left);
        // 当前节点
        if (root.val <= min_num) {
            res = res.right;
        }
        if (root.val >= max_num) {
            res = res.left;
        }
        // 访问右子树
        inorder(root.right, res.right);
    }
}

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    public TreeNode dfs(TreeNode root, int low, int high) {
        if (root == null) return root;
        root.left = dfs(root.left, low, high);
        root.right = dfs(root.right, low, high);
        if (root.val > high) {
            root = root.left;
        }
        else if (root.val < low) {
            root = root.right;
        }
        return root;
    }
}