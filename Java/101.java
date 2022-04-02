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

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> l = new LinkedList<>();
        TreeNode lr = root;
        TreeNode rr = root;
        // 根节点入队
        l.offer(root);
        l.offer(root);
        while (!l.isEmpty()){
            lr = l.poll();
            rr = l.poll();
            if (lr == null && rr == null) continue;
            if (lr == null || rr == null || lr.val != rr.val) return false;
            // 增加左右结点
            l.offer(lr.left);
            l.offer(rr.right);
            l.offer(lr.right);
            l.offer(rr.left);
        }
        return true;
    }
}