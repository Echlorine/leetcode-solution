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

class Solution538 {
    public TreeNode convertBST(TreeNode root) {
        // 中根遍历，从右边开始
        Stack<TreeNode> s = new Stack<>();
        int sum = 0;
        TreeNode p = root;
        while (true){
            while (p != null){
                s.push(p);
                p = p.right;
            }
            if (s.isEmpty()) break;
            else p = s.pop();
            sum += p.val;
            p.val = sum;
            p = p.left;
        }
        return root;
    }
}