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
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(-1, head);
        ListNode father = res; // 标记前驱结点
        boolean flag = false; // 标记当前结点是否需要删除
        while (head != null && head.next != null) {
            if (head.val != head.next.val) {
                if (flag) { // 当前结点需要删除
                    father.next = head.next;
                    flag = false; // 重置标记
                }
                else if (head.next.next != null && head.next.val == head.next.next.val) {
                    father = head;
                }
                head = head.next;
            }
            else {
                head.next = head.next.next;
                flag = true;
            }
        }
        if (flag) { // 当前结点需要删除
            father.next = head.next;
            flag = false; // 重置标记
        }
        return res.next;
    }
}