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

class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int res = 0, len = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p;
        queue.add(root);
        while (!queue.isEmpty()){
            len = queue.size();
            for (int i = 0; i < len; i++){
                p = queue.poll();
                if (p.left != null) queue.add(p.left);
                if (p.right != null) queue.add(p.right);
            }
            res++;
        }
        return res;
    }
}

// 这是递归的做法
/**
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return (maxDepth(root.left) > maxDepth(root.right) ? maxDepth(root.left) : maxDepth(root.right)) + 1;
    }
}
 */