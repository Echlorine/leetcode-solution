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
class Solution817 {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode temp = head;
        int res = 0;
        boolean flag = false;
        while (temp != null) {
            if (set.contains(temp.val)) {
                flag = true;
            } else {
                if (flag) {
                    res++;
                    flag = false;
                }
            }
            temp = temp.next;
        }
        if (flag) res++;
        return res;
    }
}