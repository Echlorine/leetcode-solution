import java.util.PriorityQueue;

class Solution778 {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> val = new PriorityQueue<>((v1, v2) -> v1[0] - v2[0]);
        int m = grid.length, n = grid[0].length;
        // 初始化优先队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                val.add(new int[] {grid[i][j], i, j});
            }
        }
        // 并查集解题
        DisjointSet disjointSet = new DisjointSet(m, n);
        for (int i = 0; i < m * n; i++) {
            int[] point = val.poll();
            int value = point[0], x = point[1], y = point[2];
            int index = x * n + y;
            grid[x][y] = -1; // 标记当前结点已经访问
            if (x + 1 < m && grid[x + 1][y] == -1) { // 判断下方
                disjointSet.union(index, index + n);
            }
            if (y + 1 < n && grid[x][y + 1] == -1) { // 判断右方
                disjointSet.union(index, index + 1);
            }
            if (x - 1 >= 0 && grid[x - 1][y] == -1) { // 判断上方
                disjointSet.union(index, index - n);
            }
            if (y - 1 >= 0 && grid[x][y - 1] == -1) { // 判断左方
                disjointSet.union(index, index - 1);
            }
            if (disjointSet.isConnected(0, m * n - 1)) return value;
        }
        return m * n - 1;
    }
    
    class DisjointSet {
        private int[] parent;
        private int[] rank;

        public DisjointSet(int m, int n) {
            this.parent = new int[m * n];
            this.rank = new int[m * n];
            for (int i = 0; i < m * n; i++) {
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
                if (rank[xRoot] <= rank[yRoot]) {
                    parent[xRoot] = yRoot;
                }
                else {
                    parent[yRoot] = xRoot;
                }
                if (rank[xRoot] == rank[yRoot]) rank[yRoot]++;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}