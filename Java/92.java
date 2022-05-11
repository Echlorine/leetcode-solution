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
class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 0;
        ListNode res = new ListNode(-1, head);
        ListNode begin = head, end = head;
        while (head != null) {
            i++;
            if (left - 1 == 0 && i == left) {
                begin = new ListNode(-1, head);
                res = begin;
            }
            else if (left - 1 == i) begin = head;
            if (i == right) end = head;
            head = head.next;
        }
        begin.next = reverseList(begin.next, end.next);
        return res.next;
    }

    public ListNode reverseList(ListNode begin, ListNode end) {
        /**
         * 递归法翻转链表
         */
        if (begin == end || begin.next == end) return begin; // 特例，没有结点或者只有一个结点
        ListNode res = reverseList(begin.next, end);
        begin.next.next = begin;
        begin.next = end;
        return res;
    }
}