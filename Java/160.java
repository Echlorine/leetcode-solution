/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;

class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        Set<ListNode> ans = new HashSet<>();
        while (a != null || b != null){
            if (ans.contains(a)) return a;
            if (a != null) ans.add(a);
            if (a != null) a = a.next;
            if (ans.contains(b)) return b;
            if (b != null) ans.add(b);
            if (b != null) b = b.next;
        }
        return null;
    }
}