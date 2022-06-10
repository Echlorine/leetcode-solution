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
class Solution206 {
    // 迭代解法
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode res = head; // 新链表的头结点
        ListNode p = res.next;
        ListNode temp;
        res.next = null;
        while (p != null) {
            temp = p.next;
            p.next = res;
            res = p;
            p = temp;
        }
        return res;
    }
    // 递归解法
    public ListNode rereverseList(ListNode head) {
        if (head == null) return head; // 特例
        if (head.next == null) return head; // 递归出口，该结点是链表的尾结点
        ListNode res = rereverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}