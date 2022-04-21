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
class Solution1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return genTree(preorder, 0, preorder.length);
    }

    public TreeNode genTree(int[] preorder, int index, int len) {
        if (len == 0) return null;
        int l = 0;
        for (int i = index; i < index + len; i++, l++)
            if (preorder[i] > preorder[index]) break;
        // 生成根节点
        TreeNode root = new TreeNode(preorder[index]);
        // 生成左子树
        root.left = genTree(preorder, index + 1, l - 1);
        // 生成右子树
        root.right = genTree(preorder, index + l, len - l);
        return root;
    }
}