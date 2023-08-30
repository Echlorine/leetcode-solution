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
class Solution {
    public TreeNode str2tree(String s) {
        // 递归出口
        if (s.equals("")) return null;
        TreeNode root = new TreeNode();
        int l = 0, r = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // 确定当前值
        while (l < s.length() && s.charAt(l) != '(') {
            l++;
            r++;
        }
        int val = Integer.valueOf(s.substring(0, l));
        root.val = val;
        for (int i = l; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                l = stack.pop();
            }
            if (stack.isEmpty()) {
                r = i;
                break;
            }
        }
        // 确定左子树
        String strLeft = "";
        if (r >= l + 1) strLeft = s.substring(l + 1, r);
        root.left = str2tree(strLeft);
        // 确定右子树
        String strRight = "";
        if (s.length() - 1 >= r + 2) strRight = s.substring(r + 2, s.length() - 1);
        root.right = str2tree(strRight);
        return root;
    }
}