class Solution803 {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length, n = grid[0].length;
        // 更新砖块最终的样子
        int[][] status = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                status[i][j] = grid[i][j];
            }
        }
        for (int i = 0; i < hits.length; i++) {
            status[hits[i][0]][hits[i][1]] = 0;
        }
        // 初始化并查集
        DisjointSet disjointSet = new DisjointSet(m, n);
        int[] res = new int[hits.length];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (status[i][j] == 1) {
                    int index = i * n + j;
                    // 顶部砖块不会掉落
                    if (index >= 0 && index <= n - 1) {
                        disjointSet.union(index, m * n);
                    }
                    if (j + 1 < n && status[i][j + 1] == 1) { // 右
                        disjointSet.union(index, index + 1);
                    }
                    if (i + 1 < m && status[i + 1][j] == 1) { // 下
                        disjointSet.union(index, index + n);
                    }
                    if (j - 1 >= 0 && status[i][j - 1] == 1) { // 左
                        disjointSet.union(index, index - 1);
                    }
                    if (i - 1 >= 0 && status[i - 1][j] == 1) { // 上
                        disjointSet.union(index, index - n);
                    }
                }
            }
        }
        // 逆序添加砖块
        for (int i = hits.length - 1; i >= 0; i--) { 
            int x = hits[i][0], y = hits[i][1];
            if (grid[x][y] == 0) { // 此处本来就不是砖块
                continue;
            }
            int index = x * n + y;
            int beforeSize = disjointSet.getSize(m * n);
            status[x][y] = 1; // 修改此处的砖块状态
            // 顶部砖块
            if (index >= 0 && index <= n - 1) {
                disjointSet.union(index, m * n);
            }
            if (y + 1 < n && status[x][y + 1] == 1) { // 右
                disjointSet.union(index, index + 1);
            }
            if (x + 1 < m && status[x + 1][y] == 1) { // 下
                disjointSet.union(index, index + n);
            }
            if (y - 1 >= 0 && status[x][y - 1] == 1) { // 左
                disjointSet.union(index, index - 1);
            }
            if (x - 1 >= 0 && status[x - 1][y] == 1) { // 上
                disjointSet.union(index, index - n);
            }
            int afterSize = disjointSet.getSize(m * n);
            res[i] = afterSize > beforeSize ? afterSize - beforeSize - 1 : 0;
        }
        return res;
    }

    class DisjointSet {
        private int[] parent;
        private int[] size;

        public DisjointSet(int m, int n) {
            this.parent = new int[m * n + 1];
            this.size = new int[m * n + 1];
            for (int i = 0; i < m * n + 1; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return find(parent[x]);
        }

        public void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot != yRoot) {
                if (size[xRoot] <= size[yRoot]) {
                    parent[xRoot] = yRoot;
                    size[yRoot] += size[xRoot];
                }
                else {
                    parent[yRoot] = xRoot;
                    size[xRoot] += size[yRoot];
                }
            }
        }

        public int getSize(int x) {
            return size[find(x)];
        }
    }
}