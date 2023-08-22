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

class Solution1522 {
    private int res = 0;

    public int diameter(Node root) {
        dfs(root);
        return res;
    }
    
    public int dfs(Node root) {
        if (root == null) return 0;
        int first = 0, second = 0;
        for (Node child: root.children) {
            int l = dfs(child);
            if (l > first) {
                second = first;
                first = l;
            } else if (l > second) {
                second = l;
            }
        }
        res = Math.max(res, first + second);
        return first + 1;
    }
}