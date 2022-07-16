import java.util.HashMap;
import java.util.Map;

class Solution947 {
    public int removeStones(int[][] stones) {
        Map<Integer, Integer> mapRow = new HashMap<>();
        Map<Integer, Integer> mapColumn = new HashMap<>();
        DisjointSet disjointSet = new DisjointSet(stones.length);
        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0], column = stones[i][1];
            if (mapRow.containsKey(row)) { // 同一行有石子
                int temp = mapRow.get(row);
                disjointSet.union(i, temp);
            }
            if (mapColumn.containsKey(column)) { // 同一列有石子
                int temp = mapColumn.get(column);
                disjointSet.union(i, temp);
            }
            mapRow.put(row, i);
            mapColumn.put(column, i);
        }
        return disjointSet.getNum();
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