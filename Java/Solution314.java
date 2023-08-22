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
class Solution314 {
    private int min, max;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        // 根节点的行号为 0
        Map<Integer, List<Integer>> map = bfs(root);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        return res;
    }

    public Map<Integer, List<Integer>> bfs(TreeNode root) {
        if (root == null) return null;
        Map<Integer, List<Integer>> ans = new HashMap<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        map.put(root, 0);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            int index = map.get(t);
            if (index < min) min = index;
            if (index > max) max = index;
            if (ans.containsKey(index)) {
                ans.get(index).add(t.val);
            } else {
                ans.put(index, new LinkedList<>());
                ans.get(index).add(t.val);
            }
            if (t.left != null) {
                map.put(t.left, index - 1);
                queue.offer(t.left);
            }
            if (t.right != null) {
                map.put(t.right, index + 1);
                queue.offer(t.right);
            }
        }
        return ans;
    }
}