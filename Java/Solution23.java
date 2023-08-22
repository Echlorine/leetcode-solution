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
class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode res = null;
        if (len == 0) return res;
        res = lists[0];
        for (int i = 1; i < len; i++){
            res = mergetwoLists(res, lists[i]);
        }
        return res;
    }

    public ListNode mergetwoLists(ListNode list1, ListNode list2){
        // 边界条件
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val){
            list1.next = mergetwoLists(list1.next, list2);
            return list1;
        }
        else{
            list2.next = mergetwoLists(list1, list2.next);
            return list2;
        }
    }
}

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null; // 特例
        if (lists.length == 1) return lists[0]; // 递归出口
        ListNode[] l = new ListNode[(lists.length + 1) / 2];
        for (int i = 0; i < lists.length; i += 2) {
            if (i + 1 < lists.length) l[i / 2] = mergeTwoLists(lists[i], lists[i + 1]);
            else l[i / 2] = lists[i];
        }
        return mergeKLists(l);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = head;
        while (l1 != null && l2 != null) {
            int v1 = l1.val, v2 = l2.val;
            ListNode t = new ListNode();
            if (v1 < v2) {
                t.val = v1;
                l1 = l1.next
            } else {
                t.val = v2;
                l2 = l2.next;
            }
            p.next = t;
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return head.next;
    }
}