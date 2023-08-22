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
class Solution545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // 只有根节点的特例
        if (root.left == null && root.right == null) return new ArrayList<>() {{add(root.val);}};
        List<Integer> res = new ArrayList<>();
        List<Integer> leftBoundary = null;
        List<Integer> rightBoundary = null;
        List<Integer> leafBoundary = new ArrayList<>();
        res.add(root.val);
        if (root.left != null) {
            leftBoundary = getLeftBoundary(root);
            for (int t : leftBoundary) res.add(t);
        }
        getLeaf(root, leafBoundary);
        for (int t : leafBoundary) res.add(t);
        if (root.right != null) {
            rightBoundary = getRightBoundary(root);
            for (int t : rightBoundary) res.add(t);
        }
        return res;
    }

    public List<Integer> getLeftBoundary(TreeNode root) {
        List<Integer> res= new LinkedList<>();
        while (root != null) {
            res.add(root.val);
            if (root.left != null) root = root.left;
            else root = root.right;
        }
        res.remove(0);
        res.remove(res.size() - 1);
        return res;
    }

    public List<Integer> getRightBoundary(TreeNode root) {
        List<Integer> res= new LinkedList<>();
        while (root != null) {
            res.add(0, root.val);
            if (root.right != null) root = root.right;
            else root = root.left;
        }
        res.remove(res.size() - 1);
        res.remove(0);
        return res;
    }

    public void getLeaf(TreeNode root, List<Integer> leafBoundary) {
        if (root == null) return;
        if (root.left == null && root.right == null) leafBoundary.add(root.val);
        getLeaf(root.left, leafBoundary);
        getLeaf(root.right, leafBoundary);
    }
}