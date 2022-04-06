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

class Solution337 {
    public int rob(TreeNode root) {
        // 解决方法二叉树dp
        return Math.max(child_rob(root, true), child_rob(root, false));
    }

    public int child_rob(TreeNode p, boolean flag) {
        // 递归方法容易超时
        int temp = 0;
        // flag表示当前节点是否被打劫
        if (p == null) return 0;
        if (flag) {
            // 当前结点已经被打劫了
            temp = p.val + child_rob(p.left, false) + child_rob(p.right, false);
        }
        else {
            // 当前结点没有被打劫
            // 状态1: 打劫左孩子，不打劫右孩子
            temp = Math.max(temp, child_rob(p.left, true) + child_rob(p.right, false));
            // 状态2: 打劫右孩子，不打劫左孩子
            temp = Math.max(temp, child_rob(p.left, false) + child_rob(p.right, true));
            // 状态3: 左右孩子都打劫
            temp = Math.max(temp, child_rob(p.left, true) + child_rob(p.right, true));
            // 状态4: 左右孩子都不打劫
            temp = Math.max(temp, child_rob(p.left, false) + child_rob(p.right, false));
        }
        return temp;
    }

    public int dp_rob(TreeNode root) {
        // dp
        HashMap<TreeNode, Integer> dpt = new HashMap<>(); // 当前结点被打劫
        HashMap<TreeNode, Integer> dpf = new HashMap<>(); // 当前结点没被打劫
        // 状态转移包含于此函数中
        dfs_rob(root, dpt, dpf);
        return Math.max(dpt.get(root), dpf.get(root));
    }

    public void dfs_rob(TreeNode root, HashMap<TreeNode, Integer> dpt, HashMap<TreeNode, Integer> dpf) {
        int temp = 0;
        if (root.left != null) dfs_rob(root.left, dpt, dpf); // 获取左节点的情况
        if (root.right != null) dfs_rob(root.right, dpt, dpf); // 获取右节点的情况
        // 打劫本结点，即子节点不能打劫
        temp = root.val + dpf.getOrDefault(root.left, 0) + dpf.getOrDefault(root.right, 0);
        dpt.put(root, temp);
        // 不打劫本结点
        temp = Math.max(dpt.getOrDefault(root.left, 0), dpf.getOrDefault(root.left, 0));
        temp += Math.max(dpt.getOrDefault(root.right, 0), dpf.getOrDefault(root.right, 0));
        dpf.put(root, temp);
    }
}