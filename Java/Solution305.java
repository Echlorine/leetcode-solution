import java.util.LinkedList;
import java.util.List;

class Solution305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        List<Integer> res = new LinkedList<>();
        DisjointSet disjointSet = new DisjointSet(m, n);
        int oneNumber = 0; // 统计矩阵中 1 的数量
        for (int i = 0; i < positions.length; i++) {
            int a = positions[i][0], b = positions[i][1];
            if (grid[a][b] == 0) {
                grid[a][b] = 1;
                oneNumber++;
            }
            int index = a * n + b;
            if (a + 1 < m && grid[a + 1][b] == 1) { // 判断下方
                disjointSet.union(index, index + n);
            }
            if (b + 1 < n && grid[a][b + 1] == 1) { // 判断右方
                disjointSet.union(index, index + 1);
            }
            if (a - 1 >= 0 && grid[a - 1][b] == 1) { // 判断上方
                disjointSet.union(index, index - n);
            }
            if (b - 1 >= 0 && grid[a][b - 1] == 1) { // 判断左方
                disjointSet.union(index, index - 1);
            }
            res.add(oneNumber - disjointSet.getNum());
        }
        return res;
    }

    class DisjointSet {
        private int[] parent;
        private int[] rank;
        private int num;

        public DisjointSet(int m, int n) {
            this.parent = new int[m * n];
            this.rank = new int[m * n];
            this.num = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int index = i * n + j;
                    parent[index] = index;
                    rank[index] = 1;
                }
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
                }
                else {
                    parent[yRoot] = xRoot;
                }
                if (rank[xRoot] == rank[yRoot]) rank[yRoot]++;
            }
        }

        public int getNum() {
            return num;
        }
    }
}