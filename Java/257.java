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

class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        dfs(root, res, ans);
        return res;
    }

    public void dfs(TreeNode p, List<String> res, List<String> ans) {
        if (p != null && p.left == null && p.right == null) {
            StringBuffer str = new StringBuffer();
            for (int i = 0; i < ans.size(); i++)
                str.append(ans.get(i) + "->");
            str.append(String.valueOf(p.val));
            res.add(str.toString());
            return;
        }
        // 访问当前节点
        ans.add(String.valueOf(p.val));
        if (p.left != null) { // 遍历左节点
            dfs(p.left, res, ans);
        }
        if (p.right != null) { // 遍历右节点
            dfs(p.right, res, ans);
        }
        ans.remove(ans.size() - 1);
    }
}