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

class Solution382 {
    private ListNode head;
    private Random random;

    public Solution382(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    public int getRandom() {
        int res = 0;
        ListNode node = head;
        for (int i = 1; node != null; node = node.next, i++) {
            if (random.nextInt(i) == 0) {
                res = node.val;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */