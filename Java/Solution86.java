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
class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(x - 1, head);
        ListNode slow = res;
        while (slow.next != null && slow.next.val < x) slow = slow.next; // slow 指向第一个要更新的位置
        ListNode fast = slow;
        while (fast.next != null) {
            while (fast.next != null && fast.next.val >= x) fast = fast.next;
            while (slow.next != null && slow.next.val < x) slow = slow.next;
            if (fast.next == null) break;
            // 修改从 slow 到 fast 之间的值
            ListNode temp = new ListNode(fast.next.val, slow.next);
            slow.next = temp;
            fast.next = fast.next.next;
        }
        return res.next;
    }
}