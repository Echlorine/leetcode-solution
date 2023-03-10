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
class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);
        int flag = 1; // 标记是正序还是反序
        while(queue.size() != 0) {
            int n = queue.size();
            LinkedList<Integer> ans = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode t = queue.poll();
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);
                if (flag == 1) ans.add(t.val);
                else ans.addFirst(t.val);
            }
            flag ^= 1;
            res.add(ans);
        }
        return res;
    }
}