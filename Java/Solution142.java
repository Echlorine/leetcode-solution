/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;

class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode p = head;
        HashMap<ListNode, Integer> visited = new HashMap<>();
        int index = 0;
        while (p != null) {
            if (visited.containsKey(p)) return p;
            visited.put(p, index);
            p = p.next;
        }
        return p;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) fast = fast.next;
            else return null;
            if (slow != null) slow = slow.next;
            if (slow == fast) {
                ListNode res = head;
                while (res != slow) {
                    res = res.next;
                    slow = slow.next;
                }
                return res;
            }
        }
        return null;
    }
}