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
class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(-1, head);
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return res.next;
    }
}