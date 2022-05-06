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
class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 思路，每次选出根节点
        return genTree(nums, 0, nums.length - 1);
    }

    public TreeNode genTree(int[] nums, int begin, int end) {
        if (begin == end) return new TreeNode(nums[begin]);
        if (begin > end) return null;
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = genTree(nums, begin, mid - 1);
        root.right = genTree(nums, mid + 1, end);
        return root;
    }
}