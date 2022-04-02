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

class Solution94 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> S = new Stack<>(); // 辅助栈
        List<Integer> res = new ArrayList<>();
        TreeNode p = root;
        while (true){
            while (p != null){
                S.push(p);
                p = p.left;
            }
            if (S.isEmpty()) break;
            else p = S.pop();
            res.add(p.val);
            p = p.right;
        }
        return res;
    }
}