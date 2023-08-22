class Solution980 {
    private int m, n, len;
    private int res;

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        len = 0;
        res = 0;
        boolean[][] visited = new boolean[m][n];
        int start = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != -1) len++;
                else visited[i][j] = true;
                if (grid[i][j] == 1) {
                    start = i * n + j;
                    visited[i][j] = true;
                }
            }
        }
        dfs(grid, visited, start, 1);
        return res;
    }

    public void dfs(int[][] grid, boolean[][] visited, int index, int dis) {
        int x = index / n, y = index % n;
        // 递归出口
        if (dis == len) {
            if (grid[x][y] == 2) res++;
            return;
        }
        // 特殊情况
        // 右
        if (y + 1 < n && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            dfs(grid, visited, index + 1, dis + 1);
            visited[x][y + 1] = false;
        }
        // 下
        if (x + 1 < m && !visited[x + 1][y]) {
            visited[x + 1][y] = true;
            dfs(grid, visited, index + n, dis + 1);
            visited[x + 1][y] = false;
        }
        // 左
        if (y - 1 >= 0 && !visited[x][y - 1]) {
            visited[x][y - 1] = true;
            dfs(grid, visited, index - 1, dis + 1);
            visited[x][y - 1] = false;
        }
        // 上
        if (x - 1 >= 0 && !visited[x - 1][y]) {
            visited[x - 1][y] = true;
            dfs(grid, visited, index - n, dis + 1);
            visited[x - 1][y] = false;
        }
    }
}