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

class Solution98 {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>(); // 辅助栈
        List<Integer> res = new ArrayList<>();
        TreeNode p = root;
        while (true){
            while (p != null){
                s.push(p);
                p = p.left;
            }
            if (s.isEmpty()) break;
            else p = s.pop();
            res.add(p.val);
            if (res.size() > 1 && res.get(res.size() - 1) <= res.get(res.size() - 2)) return false;
            p = p.right;
        }
    return true;
    }
}