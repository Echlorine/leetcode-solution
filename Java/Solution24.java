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
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode res = new ListNode(-1, head.next);
        while (head != null) {
            if (head.next == null) break;
            ListNode slow = head;
            ListNode fast = head.next;
            slow.next = fast.next;
            fast.next = slow;
            head = head.next;
            if (slow.next != null && slow.next.next != null)
                slow.next = slow.next.next;
        }
        return res.next;
    }

    public ListNode reswapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode one = head;
        ListNode two = one.next;
        ListNode three = two.next;
        two.next = one;
        one.next = reswapPairs(three);
        return two;
    }
}