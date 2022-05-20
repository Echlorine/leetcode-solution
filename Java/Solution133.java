import java.util.*;

class GraphNode {
    public int val;
    public List<GraphNode> neighbors;
    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution133 {
    private Map<GraphNode, GraphNode> map = new HashMap<>();

    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) return node;
        if (map.containsKey(node)) return map.get(node);
        GraphNode newnode = new GraphNode(node.val);
        map.put(node, newnode);
        for (GraphNode adj : node.neighbors)
            newnode.neighbors.add(cloneGraph(adj));
        return newnode;
    }
}