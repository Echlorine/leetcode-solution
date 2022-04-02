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

class Solution148 {
    public ListNode sortList(ListNode head) {
        Map<Integer, ListNode> ans = new TreeMap<>();
        ListNode p = head, temp = p;
        int index = 0;
        // 存放键值对
        while (p != null)
            {ans.put(index, p); temp = p; p = p.next; temp.next = null; index++;}
        // 快排
        quicksort(ans, 0, ans.size() - 1);
        // 还原链表
        for (int i = 0; i < index - 1; i++)
            ans.get(i).next = ans.get(i + 1);
        return ans.get(0); // 返回头指针
    }

    public void quicksort(Map<Integer, ListNode> ans, int begin, int end) {
        int j = 0;
        if (begin < end){
            j = partion(ans, begin, end);
            quicksort(ans, begin, j - 1);
            quicksort(ans, j + 1, end);
        }
    }

    public int partion(Map<Integer, ListNode> ans, int begin, int end) {
        int s = begin, e = end + 1;
        int k = ans.get(s).val;
        ListNode temp;
        while (s < e){
            s++;
            while (ans.get(s).val < k && s < end) s++;
            e--;
            while (ans.get(e).val > k) e--;
            if (s < e) {
                temp = ans.get(s);
                ans.put(s, ans.get(e));
                ans.put(e, temp);
            }
        }
        temp = ans.get(e);
        ans.put(e, ans.get(begin));
        ans.put(begin, temp);
        return e;
    }
}