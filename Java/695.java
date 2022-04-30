class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] res = new int[] {0, 0};
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    res[0] = 1;
                    dfs(grid, visited, i, j, res);
                }
        return Math.max(res[0], res[1]);
    }

    public void dfs(int[][] grid, boolean[][] visited, int x, int y, int[] res) {
        // 下移
        if (x + 1 < grid.length && grid[x + 1][y] == 1 && !visited[x + 1][y]) {
            visited[x + 1][y] = true;
            res[0]++;
            dfs(grid, visited, x + 1, y, res);
            res[1] = Math.max(res[0], res[1]);
        }
        // 右移
        if (y + 1 < grid[0].length && grid[x][y+ 1] == 1 && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            res[0]++;
            dfs(grid, visited, x, y + 1, res);
            res[1] = Math.max(res[0], res[1]);
        }
        // 上移
        if (x - 1 >= 0 && grid[x - 1][y] == 1 && !visited[x - 1][y]) {
            visited[x - 1][y] = true;
            res[0]++;
            dfs(grid, visited, x - 1, y, res);
            res[1] = Math.max(res[0], res[1]);
        }
        // 左移
        if (y - 1 >= 0 && grid[x][y - 1] == 1 && !visited[x][y - 1]) {
            visited[x][y - 1] = true;
            res[0]++;
            dfs(grid, visited, x, y - 1, res);
            res[1] = Math.max(res[0], res[1]);
        }
    }
}