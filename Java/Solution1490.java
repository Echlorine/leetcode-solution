/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution1490 {
    public Node cloneTree(Node root) {
        if (root == null) return null;
        // BFS
        Node res = new Node(root.val);
        Queue<Node> queueSrc = new ArrayDeque<>();
        Queue<Node> queueDst = new ArrayDeque<>();
        queueSrc.offer(root);
        queueDst.offer(res);
        while (!queueSrc.isEmpty()) {
            Node s = queueSrc.poll();
            Node d = queueDst.poll();
            for (Node n : s.children) {
                queueSrc.offer(n);
                Node p = new Node(n.val);
                queueDst.offer(p);
                d.children.add(p);
            }
        }
        return res;
    }
}

class Solution {
    public Node cloneTree(Node root) {
        if (root == null) return null; // 递归出口
        Node res= new Node(root.val);
        for (Node p : root.children) {
            res.children.add(cloneTree(p));
        }
        return res;
    }
}