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

class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    public void dfs(List<Integer> res, TreeNode root) {
        if (root == null) return;
        dfs(res, root.left);// 访问左孩子
        dfs(res, root.right);// 访问右孩子
        res.add(root.val); // 访问当前结点
    }

    public List<Integer> stackpostorderTraversal(TreeNode root) {
            // 后根遍历的栈实现
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            /**
             * (p, 0) 没有访问结点的任何子树，准备遍历其左子树
             * (p, 1) 遍历完左子树, 准备遍历其右子树
             * (p, 2) 遍历完右子树
             */
            Deque<TreeNode> stack = new ArrayDeque<>();
            Deque<Integer> opstack = new ArrayDeque<>();
            TreeNode p = root;
            int operation = 0;
            stack.addLast(p);
            opstack.addLast(operation);
            while (!stack.isEmpty()) {
                p = stack.removeLast();
                operation = opstack.removeLast();
                if (operation == 0) {
                    stack.addLast(p);
                    opstack.addLast(1);
                    if (p.left != null) {
                        stack.addLast(p.left);
                        opstack.addLast(0);
                    }
                }
                if (operation == 1) {
                    stack.addLast(p);
                    opstack.addLast(2);
                    if (p.right != null) {
                        stack.addLast(p.right);
                        opstack.addLast(0);
                    }
                }
                if (operation == 2)
                    res.add(p.val);
            }
            return res;
    }
}