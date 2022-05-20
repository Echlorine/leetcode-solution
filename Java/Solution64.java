class Solution64 {
    public int minPathSum(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        // dp
        res[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
        for (int i = grid[0].length - 2; i >=0 ; i--)
            res[grid.length - 1][i] = grid[grid.length - 1][i] + res[grid.length - 1][i + 1];
        for (int i = grid.length - 2; i >=0 ; i--)
            res[i][grid[0].length - 1] = grid[i][grid[0].length - 1] + res[i + 1][grid[0].length - 1];
        for (int i = grid.length - 2; i >= 0 ; i--)
            for (int j = grid[0].length - 2; j >= 0 ; j--){
                res[i][j] = res[i + 1][j] < res[i][j + 1] ? res[i + 1][j] : res[i][j + 1];
                res[i][j] += grid[i][j];
            }
        return res[0][0];
    }
}