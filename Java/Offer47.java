class Offer47 {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] values = new int[m][n];
        for (int j = 0; j < n; j++) {
            values[0][j] = grid[0][j] + (j > 0 ? values[0][j - 1] : 0);
        }
        for (int i = 0; i < m; i++) {
            values[i][0] = grid[i][0] + (i > 0 ? values[i - 1][0] : 0);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int l = values[i][j - 1] + grid[i][j];
                int u = values[i - 1][j] + grid[i][j];
                values[i][j] = Math.max(l, u);
            }
        }
        return values[m - 1][n - 1];
    }
}