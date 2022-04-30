class Solution1020 {
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1 && (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1)) {
                    visited[i][j] = true;
                    dfs(visited, grid, i, j);
                }
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1 && !visited[i][j])
                    res++;
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
}