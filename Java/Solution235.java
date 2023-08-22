/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, map);
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }
        while (!set.contains(q)) {
            q = map.get(q);
        }
        return q;
    }
    
    public void dfs(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) return;
        if (root.left != null) {
            map.put(root.left, root);
        }
        if (root.right != null) {
            map.put(root.right, root);
        }
        dfs(root.left, map);
        dfs(root.right, map);
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getPre(root, p);
        List<TreeNode> path_q = getPre(root, q);
        TreeNode res = new TreeNode();
        for (int i = 0; i < path_q.size() && i < path_p.size(); i++) {
            if (path_p.get(i) == path_q.get(i)) res = path_p.get(i);
            else break;
        }
        return res;
    }

    public List<TreeNode> getPre(TreeNode root, TreeNode d) {
        List<TreeNode> list = new ArrayList<>();
        while (root != d) {
            list.add(root);
            if (root.val > d.val) root = root.left;
            else root = root.right;
        }
        list.add(root);
        return list;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) root = root.left;
            else if (root.val < p.val && root.val < q.val) root = root.right;
            else break;
        }
        return root;
    }
}