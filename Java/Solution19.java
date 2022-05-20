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
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 1; //遍历链表时保留链表长度
        ListNode temp = head;
        ListNode trash = new ListNode(); //尾结点
        while (temp.next != null)
            {temp = temp.next; len++;}
        int i = len - n + 1; //正数第几个
        if (i==1){
            temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }
        // 定位要被删除的结点
        temp = head;
        for (int j=1; j<i; j++){
            temp = temp.next;
        }
        trash = temp;
        // 删除结点
        temp = head;
        for (int j=1; j<i-1; j++){
            temp = temp.next;
        }
        temp.next = trash.next;
        trash.next = null;
        return head;
    }
}