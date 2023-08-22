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
class Solution1474 {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode p = head;
        int r_num = 0, d_num = 0;
        boolean flag = true;
        ListNode t = head; // 标记处于删除状态的节点
        while (head != null) {
            if (flag) {
                // 处于保留状态
                while (r_num < m && head != null) {
                    t = head;
                    head = head.next;
                    r_num++;
                }
                flag = false;
                r_num = 0;
            } else {
                // 处于删除状态
                while(d_num < n && head != null) {
                    head = head.next;
                    d_num++;
                }
                flag = true;
                d_num = 0;
                t.next = head;
            }
        }
        return p;
    }
}