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
class Solution143 {
    public void reorderList(ListNode head) {
        ListNode mid = getMidList(head);
        ListNode right = reverseList(mid);
        mergeList(head, right);
    }

    // 找到链表的中点
    public ListNode getMidList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) fast = fast.next;
            else break;
            slow = slow.next;
        }
        return slow;
    }

    // 翻转中点右侧的链表
    public ListNode reverseList(ListNode head) {
        // 递归出口
        if (head.next == null) return head;
        ListNode res =  reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    // 合并两个链表
    public void mergeList(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode l1_t = l1.next, l2_t = l2.next;
            
            l1.next = l2;
            if(l2.next != null) l2.next = l1_t;
            
            l1 = l1_t;
            l2 = l2_t;
        }
    }
}