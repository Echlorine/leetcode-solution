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
class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        int i = 0;
        ListNode end = head;
        ListNode begin = head;
        while(head != null) {
            i++;
            if (i == k)
                end = head;
            head = head.next;
            if (i == k)
                break;
        }
        ListNode res = reverseList(begin, end.next);
        begin.next = reverseKGroup(begin.next, k);
        return res;
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

class Solution {
    private int k;

    public ListNode reverseKGroup(ListNode head, int k) {
        this.k = k;
        // 递归出口
        int t = 0;
        ListNode res = head;
        while (t < k) {
            if (head == null) return res;
            head = head.next;
            t++;
        }
        // 处理
        ListNode p = reverseKGroup(head, k);
        ListNode q = reverse(res, 1);
        res.next = p;
        return q;
    }

    public ListNode reverse(ListNode root, int k) {
        if (k >= this.k) return root;
        ListNode p = reverse(root.next, k + 1);
        root.next.next = root;
        root.next = null;
        return p;
    }
}