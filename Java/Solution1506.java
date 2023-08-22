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

class Solution1506 {
    public Node findRoot(List<Node> tree) {
        Map<Node, Boolean> visited = new HashMap<>();
        Set<Node> set = new HashSet<>();
        for (Node t : tree) {
            dfs(t, visited, set);
        }
        for (Node t : tree) {
            if (!set.contains(t)) return t;
        }
        return null;
    }
    
    public void dfs(Node root, Map<Node, Boolean> visited, Set<Node> set) {
        if (root == null) return;
        for (Node t : root.children) {
            if (!visited.containsKey(t)) {
                visited.put(t, true);
                set.add(t);
            }
        }
    }
}

class Solution {
    public Node findRoot(List<Node> tree) {
        Set<Node> set = new HashSet<>();
        // tree 集合可以看成一个邻接表
        for (Node t : tree) {
            for (Node child : t.children) {
                set.add(child);
            }
        }
        for (Node t : tree) {
            if (!set.contains(t)) return t;
        }
        return null;
    }
}