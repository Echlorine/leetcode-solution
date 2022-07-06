class Solution1020 {
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = 0;
        // 使用dfs解题
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1 && (i == 0 || i == n - 1 || j == 0 || j == m - 1)) {
                    visited[i][j] = true;
                    dfs(visited, grid, i, j);
                }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1 && !visited[i][j])
                    res++;
        // return res;
        
        // 使用并查集解题
        res = 0;
        DisjointSet disjointSet = new DisjointSet(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (j + 1 < m && grid[i][j + 1] == 1) { // 横向相邻
                        disjointSet.union(i * m + j, i * m + j + 1);
                    }
                    if (i + 1 < n && grid[i + 1][j] == 1) { // 纵向相邻
                        disjointSet.union(i * m + j, i * m + j + m);
                    }
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 1 && !disjointSet.getnearEdge(i * m + j)) {
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(boolean[][] visited, int[][] grid, int x, int y) {
        // 下移
        if (x + 1 < grid.length && grid[x + 1][y] == 1 && !visited[x + 1][y]) {
            visited[x + 1][y] = true;
            dfs(visited, grid, x + 1, y);
        }
        // 右移
        if (y + 1 < grid[0].length && grid[x][y+ 1] == 1 && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            dfs(visited, grid, x, y + 1);
        }
        // 上移
        if (x - 1 >= 0 && grid[x - 1][y] == 1 && !visited[x - 1][y]) {
            visited[x - 1][y] = true;
            dfs(visited, grid, x - 1, y);
        }
        // 左移
        if (y - 1 >= 0 && grid[x][y - 1] == 1 && !visited[x][y - 1]) {
            visited[x][y - 1] = true;
            dfs(visited, grid, x, y - 1);
        }
    }

    class DisjointSet {

        private int[] parent;
        private int[] rank; // 按秩合并，根据实际情况确定是按大小合并还是按秩合并
        private boolean[] nearEdge; // 标记当前并查集是否与边界相连
    
        public DisjointSet(int n, int m) {
            // 初始化并查集
            this.parent = new int[n * m];
            this.rank = new int[n * m];
            this.nearEdge = new boolean[n * m];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int index = i * m + j;
                    parent[index] = index;
                    rank[index] = 1;
                    if (i == 0 || i == n - 1 || j == 0 || j == m - 1) nearEdge[index] = true;
                    else nearEdge[index] = false;
                }
            }
        }
    
        /**
         * 带路径压缩的查找
         * @param x
         * @return int
         */
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    
        /**
         * 按秩合并
         * @param x
         * @param y
         */
        public void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot != yRoot) {
                if (rank[xRoot] <= rank[yRoot]) {
                    parent[xRoot] = yRoot;
                    nearEdge[yRoot] |= nearEdge[xRoot];
                }
                else {
                    parent[yRoot] = xRoot;
                    nearEdge[xRoot] |= nearEdge[yRoot];
                }
                if (rank[xRoot] == rank[yRoot]) rank[yRoot]++;
            }
        }

        public boolean getnearEdge(int x) {
            return nearEdge[find(x)];
        }
    }
}