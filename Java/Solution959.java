class Solution959 {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        DisjointSet disjointSet = new DisjointSet(n * n * 4);
        for (int i = 0; i < n; i++) {
            char[] chars = grid[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int firstGrid = i * n + j; // 小正方形的序号
                int smallGrid = firstGrid * 4; // 小正方形中第一个区域的序号
                if (chars[j] == ' ') { // 空格
                    // 区域合并
                    disjointSet.union(smallGrid, smallGrid + 1);
                    disjointSet.union(smallGrid, smallGrid + 2);
                    disjointSet.union(smallGrid, smallGrid + 3);
                } else if (chars[j] == '/') { // /
                    // 区域合并
                    disjointSet.union(smallGrid, smallGrid + 3);
                    disjointSet.union(smallGrid + 1, smallGrid + 2);
                } else { // \
                    // 区域合并
                    disjointSet.union(smallGrid, smallGrid + 1);
                    disjointSet.union(smallGrid + 2, smallGrid + 3);
                }
                // 合并四周
                if (i != 0) { // 上方
                    disjointSet.union(smallGrid, smallGrid - 4 * n + 2);
                }
                if (j != n - 1) { // 右方
                    disjointSet.union(smallGrid + 1, smallGrid + 7);
                }
                if (i != n -1) { // 下方
                    disjointSet.union(smallGrid + 2, smallGrid + 4 * n);
                }
                if (j != 0) { // 左方
                    disjointSet.union(smallGrid + 3, smallGrid - 3);
                }
            }
        }
        return n * n * 4 - disjointSet.getNum();
    }

    class DisjointSet {
        private int[] parent;
        private int[] rank;
        private int num;

        public DisjointSet(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            this.num = 0;
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
                }
                else {
                    parent[yRoot] = xRoot;
                }
                if (rank[xRoot] == rank[yRoot]) rank[yRoot] += 1;
            }
        }

        public int getNum() {
            return num;
        }
    }
}