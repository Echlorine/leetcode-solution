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
class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        ListNode r = new ListNode(p.val), nr;
        p = p.next;
        while (p != null) {
            nr = new ListNode();
            nr.val = p.val;
            nr.next = r;
            r = nr;
            p = p.next;
        }
        p = head;
        while (p != null && r != null){
            if (p.val != r.val) return false;
            p = p.next;
            r = r.next;
        }
        return true;
    }
}