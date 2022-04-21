/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;`
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
class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return genTree(inorder, postorder, 0, 0, inorder.length);
    }

    public TreeNode genTree(int[] inorder, int[] postorder, int inindex, int postindex, int len) {
        if (len == 0) return null;
        // 确定左右子树位置
        int index = 0, target = postorder[postindex + len - 1];
        for (int i = inindex; i < inorder.length; i++, index++)
            if (inorder[i] == target) break;
        TreeNode root = new TreeNode(target); // 生成根节点
        root.left = genTree(inorder, postorder, inindex, postindex, index); // 左子树
        root.right = genTree(inorder, postorder, inindex + index + 1, postindex + index, len - 1 - index); // 右子树
        return root;
    }
}