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

class Solution148 {
    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        ListNode res = new ListNode(0, head); // 哨兵结点
        // 合并排序
        int l = 1;
        while (l < len) {
            ListNode pre = res, curr = res.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < l && curr.next != null; i++)
                    curr = curr.next;
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < l && curr != null && curr.next != null; i++)
                    curr = curr.next;
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                
                ListNode merged = merge(head1, head2);
                pre.next = merged;
                while (pre.next != null)
                    pre = pre.next;
                curr = next;
            }
            l *= 2;
        }
        return res.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode Head = new ListNode(0);
        ListNode p = Head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                p.next = head1;
                head1 = head1.next;
            }
            else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if (head1 == null) p.next = head2;
        if (head2 == null) p.next = head1;
        return Head.next;
    }
}