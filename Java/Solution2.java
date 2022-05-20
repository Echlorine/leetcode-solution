class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int temp, num1, num2;
        num1 = 0;
        while (l1 != null || l2 != null) {
            int val1, val2;
            if (l1 == null) {val1 = 0;}
            else {val1 = l1.val; l1 = l1.next;}
            if (l2 == null) {val2 = 0;}
            else {val2 = l2.val; l2 = l2.next;}
            temp = val1 + val2 + num1;
            num2 = temp % 10;
            num1 = temp / 10;
            if (head == null)
                head = tail = new ListNode(num2);
            else{
                tail.next = new ListNode(num2);
                tail = tail.next;
            }
        }
        if (num1 == 1) {
            tail.next = new ListNode(num1);
        }
        return head;
    }
}