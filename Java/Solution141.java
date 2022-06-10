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
class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, low = head;
        while (fast != null){
            fast = fast.next;
            if (fast != null) fast = fast.next;
            else return false;
            low = low.next;
            if (fast == low) return true;
        }
        return false;
    }
}