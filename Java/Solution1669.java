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
class Solution1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head, tail;
        head = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        tail = list2;
        ListNode res = new ListNode(0, list1);
        int index = 1;
        ListNode cur = list1;
        while(index < a) {
            cur = cur.next;
            index++;
        }
        ListNode last = cur;
        while(index <= b) {
            cur = cur.next;
            index++;
        }
        last.next = head;
        tail.next = cur.next;
        return res.next;
    }
}