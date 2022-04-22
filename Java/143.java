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
import java.util.*;

class Solution143 {
    public void reorderList(ListNode head) {
        ListNode left = head, right = head;
        Map<ListNode, ListNode> map = new HashMap<>();
        while (right.next != null) {
            map.put(right.next, right);
            right = right.next;
        }
        while (left.next != right || left != right) {
            ListNode temp1 = left.next, temp2 = right;
            left.next = right;
            right.next = temp1;
            left = temp1;
            right = map.get(temp2);
        }
    }
}