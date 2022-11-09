class Solution685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(edges.length);
        int conflict = -1, round = -1; // 标记冲突和环路
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (disjointSet.getParent(edge[1] - 1) != edge[1] - 1) {
                conflict = i;
            } else {
                if (disjointSet.find(edge[0] - 1) != disjointSet.find(edge[1] - 1)) {
                    disjointSet.union(edge[0] - 1, edge[1] - 1);
                } else {
                    round = i;
                }
            }
        }
        if (conflict == -1) {
            // 没有冲突，只有环路
            return edges[round];
        } else {
            if (round == -1) {
                // 只有冲突，没有环路
                return edges[conflict];
            } else {
                // 既有冲突也有环路
                for (int k = 0; k < edges.length; k++) {
                    if (edges[k][1] == edges[conflict][1] && k != conflict) {
                        return disjointSet.find(edges[k][0] - 1) == disjointSet.find(edges[k][1] - 1) ? edges[k] : edges[conflict];
                    }
                }
            }
        }
        return null;
    }

    class DisjointSet {
        private int[] parent;

        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            if (find(x) != find(y)) {
                parent[y] = x;
            }
        }

        public int getParent(int x) {
            return parent[x];
        }
    }
}