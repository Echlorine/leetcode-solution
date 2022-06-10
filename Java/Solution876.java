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
class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode left = head, right = head;
        while (right.next != null) {
            left = left.next;
            right = right.next;
            if (right == null) break;
            right = right.next;
            if (right == null) break;
        }
        return left;
    }
}