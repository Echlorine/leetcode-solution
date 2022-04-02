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

class Solution114 {
    public void flatten(TreeNode root) {
        // 思路，将左边的树加在根节点与右子树中间
        while (root != null) {
            change(root, root.left);
            root = root.right;
        }
    }

    public void change(TreeNode father, TreeNode root){
        TreeNode p = father.right;
        // 当前节点的左子树不为空，递归合并
        if (root != null && root.left != null) change(root, root.left);
        if (root == null) return;
        // 当前结点的左子树为空，直接合并
        else {
            father.left = null;
            father.right = root;
            while (root.right != null) 
                root = root.right;
            root.right = p;
        }
    }
}