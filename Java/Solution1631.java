import java.util.PriorityQueue;

class Solution1631 {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((v1, v2) -> v1[0] - v2[0]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) { // 右
                    int val = Math.abs(heights[i][j + 1] - heights[i][j]);
                    queue.add(new int[] {val, i, j});
                }
                if (i + 1 < m) { // 下
                    int val = Math.abs(heights[i + 1][j] - heights[i][j]);
                    queue.add(new int[] {val, i, j});
                }
            }
        }
        DisjointSet disjointSet = new DisjointSet(m, n);
        int size = queue.size();
        for (int ans = 0; ans < size; ans++) {
            int[] point = queue.poll();
            int val = point[0], i = point[1], j = point[2];
            int index = i * n + j;
            if (j + 1 < n && Math.abs(heights[i][j + 1] - heights[i][j]) <= val) { // 右
                disjointSet.union(index, index + 1);
            }
            if (i + 1 < m && Math.abs(heights[i + 1][j] - heights[i][j]) <= val) { // 下
                disjointSet.union(index, index + n);
            }
            if (j - 1 >= 0 && Math.abs(heights[i][j - 1] - heights[i][j]) <= val) { // 左
                disjointSet.union(index, index - 1);
            }
            if (i - 1 >= 0 && Math.abs(heights[i - 1][j] - heights[i][j]) <= val) { // 上
                disjointSet.union(index, index - n);
            }   
            if (disjointSet.isConnected(0, m * n - 1)) return val;
        }
        return 0;
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
                } else {
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