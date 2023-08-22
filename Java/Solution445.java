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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        while(l1 != null || l2 != null) {
            if (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }
        }
        // 开始数值相加
        int n1 = 0, n2 = 0, n3 = 0;
        ListNode head = null, pre = new ListNode();
        while(!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                n1 = s1.pop();
            } else {
                n1 = 0;
            }
            if (!s2.isEmpty()) {
                n2 = s2.pop();
            } else {
                n2 = 0;
            }
            int n = (n1 + n2 + n3) % 10;
            n3 = (n1 + n2 + n3) / 10;
            // 链表头部插入节点
            ListNode temp = new ListNode(n);
            pre.next = temp;
            if (head != null) temp.next = head;
            head = temp;
        }
        if (n3 != 0) {
            ListNode temp = new ListNode(n3);
            pre.next = temp;
            temp.next = head;
        }
        return pre.next;
    }
}