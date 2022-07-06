import java.util.*;

class Solution1102 {
    public int maximumMinimumPath(int[][] grid) {
        PriorityQueue<int[]> val = new PriorityQueue<>((v1, v2) -> v2[0] - v1[0]);
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        DisjointSet disjointSet = new DisjointSet(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                val.add(new int[] {grid[i][j], i, j});
            }
        }
        for (int i = 0; i < m * n; i++) {
            int[] point = val.poll();
            int value = point[0], x = point[1], y = point[2];
            int index = x * n + y;
            visited[x][y] = true;
            if (x + 1 < m && visited[x + 1][y]) { // 判断下方
                disjointSet.union(index, index + n);
            }
            if (y + 1 < n && visited[x][y + 1]) { // 判断右方
                disjointSet.union(index, index + 1);
            }
            if (x - 1 >= 0 && visited[x - 1][y]) { // 判断上方
                disjointSet.union(index, index - n);
            }
            if (y - 1 >= 0 && visited[x][y - 1]) { // 判断左方
                disjointSet.union(index, index - 1);
            }
            if (disjointSet.isConnected()) return value;
        }
        return -1;
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
                else parent[yRoot] = xRoot;
                if (rank[xRoot] == rank[yRoot]) rank[yRoot]++;
            }
        }

        public boolean isConnected() {
            return find(0) == find(parent.length - 1);
        }
    }
}