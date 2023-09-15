class Solution2596 {
    private int[][] dirs = new int[][] {
        new int[] {-2, 1},
        new int[] {-1, 2},
        new int[] {1, 2},
        new int[] {2, 1},
        new int[] {2, -1},
        new int[] {1, -2},
        new int[] {-1, -2},
        new int[] {-2, -1}
    };

    private int n;

    public boolean checkValidGrid(int[][] grid) {
        n = grid.length;
        if (grid[0][0] == 0) return dfs(grid, 0, 0, 0);
        return false;
    }

    public boolean dfs(int[][] grid, int x ,int y, int index) {
        if (grid[x][y] == n * n - 1) return true;
        for (int[] dir : dirs) {
            if (x + dir[0] >= 0 && x + dir[0] < n && y + dir[1] >= 0 && y + dir[1] < n) {
                if (grid[x + dir[0]][y + dir[1]] != index + 1) continue;
                return dfs(grid, x + dir[0], y + dir[1], index + 1);
            }
        }
        return false;
    }
}