class Solution200 {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length]; // 标记每个点
        int res = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1' && visited[i][j] != 1) {
                    visited[i][j] = 1;
                    dfs(grid, visited, i, j);
                    res++;
                }
                else {visited[i][j] = 1; continue;}
            }
        return res;
    }

    public void dfs(char[][] grid, int[][] visited, int x, int y) {
        // 向下访问
        if (x + 1 < grid.length && visited[x + 1][y] != 1 && grid[x + 1][y] == '1'){
            visited[x + 1][y] = 1;
            dfs(grid, visited, x + 1, y);
        }
        // 向上访问
        if (x - 1 >= 0 && visited[x - 1][y] != 1 && grid[x - 1][y] == '1'){
            visited[x - 1][y] = 1;
            dfs(grid, visited, x - 1, y);
        }
        // 向左访问
        if (y - 1 >= 0 && visited[x][y - 1] != 1 && grid[x][y - 1] == '1'){
            visited[x][y - 1] = 1;
            dfs(grid, visited, x, y - 1);
        }
        // 向右访问
        if (y + 1 < grid[0].length && visited[x][y + 1] != 1 && grid[x][y + 1] == '1'){
            visited[x][y + 1] = 1;
            dfs(grid, visited, x, y + 1);
        }
    }
}