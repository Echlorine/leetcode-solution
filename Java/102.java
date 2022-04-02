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

 class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        int n = 0; // 某一层的结点数量
        queue.add(p);
        while (!queue.isEmpty()){
            n = queue.size();
            List<Integer> ans  = new ArrayList<>();
            for (int i = 0; i < n; i++){
                p = queue.poll();
                ans.add(p.val);
                if (p.left != null ) queue.add(p.left);
                if (p.right != null ) queue.add(p.right);
            }
            res.add(ans);
        }
        return res;
    }
}