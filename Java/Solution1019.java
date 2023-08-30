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
class Solution1019 {
    public int[] nextLargerNodes(ListNode head) {
        Deque<Integer> monotonicStack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            // 每次出栈就代表遇到了比自己大的元素
            int i = list.size() - 1;
            while(!monotonicStack.isEmpty() && monotonicStack.peek() < head.val) {
                monotonicStack.pop();
                while(list.get(i) != 0) {
                    i--;
                }
                list.set(i, head.val);
                i--;
            }
            list.add(0);
            monotonicStack.push(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}