import java.util.Arrays;

class Solution1135 {
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (v1, v2) -> v1[2]-v2[2]);
        DisjointSet disjointSet = new DisjointSet(n);
        int res = 0;
        for (int[] connection : connections) {
            if (disjointSet.find(connection[0] - 1) != disjointSet.find(connection[1] - 1)) {
                disjointSet.union(connection[0] - 1, connection[1] - 1);
                res += connection[2];
            }
            if (disjointSet.getNum() == 1) {
                return res;
            }
        }
        return -1;
    }
    
    class DisjointSet {
        private int[] parent;
        private int[] rank;
        private int num_Connected_Component;
    
        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            num_Connected_Component = n;
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
                num_Connected_Component--;
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
            return this.num_Connected_Component;
        }
    }
}