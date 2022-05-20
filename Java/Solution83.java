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
class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(-1, head);
        while (head != null && head.next != null) {
            if (head.val != head.next.val) {head = head.next; continue;}
            head.next = head.next.next;
        }
        return res.next;
    }
}