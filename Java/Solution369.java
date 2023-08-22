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
class Solution369 {
    public ListNode plusOne(ListNode head) {
        ListNode pre = new ListNode(0, head);
        ListNode p = pre;
        ListNode flag = pre;
        while(p != null) {
            if (p.val != 9) flag = p;
            p = p.next;
        }
        flag.val++;
        flag = flag.next;
        while(flag != null) {
            flag.val = 0;
            flag = flag.next;
        }
        return pre.val == 0 ? pre.next : pre;
    }
}