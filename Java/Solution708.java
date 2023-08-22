/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution708 {
    public Node insert(Node head, int insertVal) {
        Node t = new Node(insertVal);
        if (head == null) {
            t.next = t;
            return t;
        }
        Node pre = head, tail = head;
        Set<Node> set = new HashSet<>();
        Node p = head;
        // 确定首尾
        while (head.next.val >= head.val && !set.contains(head.next)) {
            set.add(head);
            head = head.next;
        }
        pre = head.next;
        tail = head;
        // 在首尾插入
        if (tail.val < insertVal || insertVal < pre.val) {
            tail.next = t;
            t.next = pre;
            return p;
        }
        // 在中间插入
        while (head.val > insertVal || insertVal > head.next.val) {
            head = head.next;
        }
        t.next = head.next;
        head.next = t;
        return p;
    }
}