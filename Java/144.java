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

class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    public void dfs(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val); // 访问当前结点
        dfs(res, root.left);// 访问左孩子
        dfs(res, root.right);// 访问右孩子
    }

    public List<Integer> stackpreorderTraversal(TreeNode root) {
        // 先根遍历的栈实现
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        /**
         * (p, 0) 此时没有访问p，准备访问p，将(p, 1)压栈
         * (p, 1) 此时访问了本身，没有访问左子树，准备访问p的左子树，将(p, 2)压栈
         * (p, 2) 此时访问了本身和左子树，准备访问p的右子树
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
                res.add(p.val);
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
        }
        return res;
    }
}