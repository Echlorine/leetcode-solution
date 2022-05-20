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
class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode right = head;
        int len = 0;
        while (right != null) {
            len++;
            right = right.next;
        }
        int l = k % len;
        if (l ==0) return head;
        right = head;
        len = 0;
        ListNode left = head;
        while (right.next != null) {
            if (len >= l) left = left.next;
            right = right.next;
            len++;        
        }
        ListNode res = left.next;
        right.next = head;
        left.next = null;
        return res;
    }
}