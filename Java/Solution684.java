import java.util.*;

class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        // 用 邻接矩阵 表示无向图
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            // 两个结点只要有一个不在当前图中，则当前边一定不多余
            if (!contain(adj, edges[i][0]) || !contain(adj, edges[i][1])) {
                // 构建图
                adj.get(edges[i][0]).add(edges[i][1]);
                adj.get(edges[i][1]).add(edges[i][0]);
            }
            else { // 否则遍历，确定当前待添加的两个顶点是否已经可达
                boolean[] visited = new boolean[edges.length + 1];
                if (dfs(adj, visited, edges[i][0], edges[i][1])) {
                    res = edges[i]; // 当前边多余
                    break;
                }
                else {
                    // 构建图
                    adj.get(edges[i][0]).add(edges[i][1]);
                    adj.get(edges[i][1]).add(edges[i][0]);
                }
            }
        }
        return res;
    }

    public boolean contain(List<List<Integer>> adj, int veradj) {
        // 判断某一个结点是否在图中
        if (adj.get(veradj).size() != 0) return true;
        return false;
    }

    public boolean dfs(List<List<Integer>> adj, boolean[] visited, int start, int end) {
        if (start == end) return true;
        visited[start] = true; // 访问当前结点
        List<Integer> veradjs = adj.get(start);
        for (int veradj : veradjs) {
            if (visited[veradj]) continue;
            if (dfs(adj, visited, veradj, end)) return true;
        }
        return false;
    }
}

class SolutionDithDisjointSet684 {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(edges.length);
        for (int[] edge : edges) {
            if (disjointSet.find(edge[0] - 1) != disjointSet.find(edge[1] - 1)) {
                disjointSet.union(edge[0] - 1, edge[1] - 1);
            } else {
                return edge;
            }
        }
        return null;
    }

    class DisjointSet {
        private int[] parent;
        private int[] rank;
        private int num;

        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            num = 0;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot != yRoot) {
                num++;
                if (rank[xRoot] <= rank[yRoot]) {
                    parent[xRoot] = yRoot;
                } else {
                    parent[yRoot] = xRoot;
                }
                if (rank[xRoot] == rank[yRoot]) {
                    rank[yRoot]++;
                }
            }
        }

        public int getNum() {
            return this.num;
        }
    }
}