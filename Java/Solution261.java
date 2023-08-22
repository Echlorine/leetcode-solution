class SolutionWithDisjoinSet261 {
    public boolean validTree(int n, int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(n);
        for (int[] edge : edges) {
            if (disjointSet.find(edge[0]) == disjointSet.find(edge[1])) {
                return false;
            }
            disjointSet.union(edge[0], edge[1]);
        }
        return n - disjointSet.getNum() == 1;
    }

    class DisjointSet {
        private int[] parent;
        private int[] rank;
        private int num;

        public DisjointSet(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
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
                this.num++;
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