class Solution2373 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) { // 右移
            for (int j = 1; j < n - 1; j++) { // 下移
                int max = grid[i][j];
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        max = Math.max(max, grid[x][y]);
                    }
                }
                res[i - 1][j - 1] = max;
            }
        }
        return res;
    }
}