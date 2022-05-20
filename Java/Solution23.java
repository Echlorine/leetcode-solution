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