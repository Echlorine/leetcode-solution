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

class Solution652 {

    private List<TreeNode> res;
    private Map<List<Integer>, Integer> map;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new LinkedList<TreeNode>();
        map = new HashMap<>();
        postorder(root);
        return res;
    }

    public List<Integer> postorder(TreeNode root) {
        if (root == null) {
            List<Integer> slist = new LinkedList<Integer>();
            slist.add(201);
            return slist;
        }
        // 左孩子
        List<Integer> llist = postorder(root.left);
        // 右孩子
        List<Integer> rlist= postorder(root.right);
        // 自身
        List<Integer> slist = new LinkedList<>();
        slist.addAll(llist);
        slist.addAll(rlist);
        slist.add(root.val);
        int num = map.getOrDefault(slist, 0);
        if (num == 1) res.add(root);
        map.put(slist, ++num);
        return slist;
    }
}