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

// preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return genTree(preorder, inorder);
    }

    public TreeNode genTree(int[] pretree, int[] intree){
        int index = 0;
        if (pretree.length == 0) return null; // 当前子树为空
        TreeNode p = new TreeNode(pretree[0]); // 建立根节点
        p.val = pretree[0];
        // 找到当前的根节点, 以及当前根节点在中根序列的位置
        for (int i = 0; i < intree.length; i++)
            if (intree[i] == pretree[0]) {index = i; break;}
        int[] lpre = new int[index]; // 左子树前根序列
        int[] lin = new int [index]; // 左子树中根序列
        int[] rpre = new int[pretree.length - 1 - index]; // 右子树前根序列
        int[] rin = new int [pretree.length - 1 - index]; // 右子树中根序列
        // 生成左子树的先根与中根序列
        for (int i = 0; i < index; i++){
            lpre[i] = pretree[i + 1];
            lin[i] = intree[i];
        }
        p.left = genTree(lpre, lin);
        // 生成右子树的先根与中根序列
        for (int i = index + 1; i < intree.length; i++){
            rpre[i - 1 - index] = pretree[i];
            rin[i - 1 - index] = intree[i];
        }
        p.right = genTree(rpre, rin);
        return p;
    }
}