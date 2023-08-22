/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 思路
        Map<TreeNode, TreeNode> map = new HashMap<>();
        HashSet<TreeNode> ans = new HashSet<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode t = root;
        // 遍历树，对每一个结点与父节点匹配
        while (true){
            while (t != null){
                s.push(t);
                t = t.left;
            }
            if (s.isEmpty()) break;
            else t = s.pop();
            // 对于每一个结点，设置键值对
            if (t.left != null) map.put(t.left, t);
            if (t.right != null) map.put(t.right, t);
            t = t.right;
        }
        while (p != null) {
            ans.add(p);
            p = map.get(p);
        }
        while (true) {
            if (ans.contains(q)) return q;
            q = map.get(q);
        }
    }
}


class Solution {
    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p ,q);
        return res;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        boolean flag = (left && right) || ((root == p || root == q) && (left || right));
        if (flag) res = root;
        return left || right || root == p || root == q;
    }
}