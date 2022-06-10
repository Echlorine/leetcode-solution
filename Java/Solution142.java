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