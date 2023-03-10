/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution117 {
    public Node connect(Node root) {
        bfs(root);
        return root;
    }

    public void bfs(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node t = queue.poll();
                if (i == n - 1) t.next = null;
                else t.next = queue.peek();
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);
            }
        }
        return;
    }
}