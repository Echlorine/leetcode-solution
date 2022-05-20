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
import java.util.*;

class Solution437 {
    public int pathSum(TreeNode root, int targetSum) {
        // 把每一个结点作为根结点，遍历
        int res = 0;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (true) {
            TreeNode p = s.pop();
            res += sum(p, targetSum);
            if (p.left != null) s.push(p.left);
            if (p.right != null) s.push(p.right);
            if (s.isEmpty()) break;
        }
        return res;
    }

    public int sum(TreeNode root, int target) {
        // 只能dfs
        int l = 0, m = 0, r = 0;
        if (root.left == null && root.right == null) return root.val == target ? 1 : 0;
        // 遍历根节点
        if (root.val == target) m = 1;
        // 遍历左子树
        if (root.left != null) l = sum(root.left, target - root.val);
        // 遍历右子树
        if (root.right != null) r = sum(root.right, target - root.val);
        return l + m + r;
    }
}