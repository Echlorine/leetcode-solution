/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
    // 思路1，将链表转化为数组，同108
    // 思路2，每次找到链表的中间位置
    return genTree(head, null);
    }

    public TreeNode genTree(ListNode begin, ListNode end) {
        if (begin == end) return null;
        ListNode mid = getmid(begin, end);
        TreeNode root = new TreeNode(mid.val);
        root.left = genTree(begin, mid);
        root.right = genTree(mid.next, end);
        return root;
    }

    public ListNode getmid(ListNode begin, ListNode end) {
        ListNode fast = begin, slow = begin;
        while (fast != end) {
            fast = fast.next;
            if (fast == end) break;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}