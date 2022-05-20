/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
import java.util.*;

class Solution590 {
    public List<Integer> postorder(Node root) {
        // 后根遍历的栈实现
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new ArrayDeque<>();
        Deque<Integer> opstack = new ArrayDeque<>();
        Node p = root;
        int operation = 0;
        stack.addLast(p);
        opstack.addLast(operation);
        while (!stack.isEmpty()) {
            p = stack.removeLast();
            operation = opstack.removeLast();
            if (p.children.size() == 0) res.add(p.val);
            else {
                if (operation < p.children.size()) {
                    stack.addLast(p);
                    opstack.addLast(operation + 1);
                    stack.addLast(p.children.get(operation));
                    opstack.addLast(0);
                }
                if (operation == p.children.size())
                    res.add(p.val); // 访问当前结点
            }
        }
        return res;
    }
}