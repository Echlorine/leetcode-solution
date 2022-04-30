class Solution1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int target = grid[row][col];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean[][] corlor = new boolean[grid.length][grid[0].length];
        corlor[row][col] = deterbordder(grid, row, col); // 判断自己是不是边界
        dfs(visited, grid, target, corlor, row, col);
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (corlor[i][j])
                    grid[i][j] = color;
        return grid;
    }

    public void dfs(boolean[][] visited, int[][] grid, int target, boolean[][] corlor, int x, int y) {
        // 下移
        if (x + 1 < grid.length && grid[x + 1][y] == target && !visited[x + 1][y]) {
            visited[x + 1][y] = true;
            corlor[x + 1][y] = deterbordder(grid, x + 1, y);
            dfs(visited, grid, target, corlor, x + 1, y);
        }
        // 右移
        if (y + 1 < grid[0].length && grid[x][y+ 1] == target && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            corlor[x][y + 1] = deterbordder(grid, x, y + 1);
            dfs(visited, grid, target, corlor, x, y + 1);
        }
        // 上移
        if (x - 1 >= 0 && grid[x - 1][y] == target && !visited[x - 1][y]) {
            visited[x - 1][y] = true;
            corlor[x - 1][y] = deterbordder(grid, x - 1, y);
            dfs(visited, grid, target, corlor, x - 1, y);
        }
        // 左移
        if (y - 1 >= 0 && grid[x][y - 1] == target && !visited[x][y - 1]) {
            visited[x][y - 1] = true;
            corlor[x][y - 1] = deterbordder(grid, x, y - 1);
            dfs(visited, grid, target, corlor, x, y - 1);
        }
    }

    public boolean deterbordder(int[][] grid, int x, int y) {
        if (x == 0 || x == grid.length - 1 || y == 0 || y == grid[0].length - 1) return true; // 边界
        boolean flag = false;
        flag = flag || grid[x + 1][y] != grid[x][y] || grid[x][y+ 1] != grid[x][y] || grid[x - 1][y] != grid[x][y] || grid[x][y - 1] != grid[x][y];
        return flag;
    }
}