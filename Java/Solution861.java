class Solution861 {
    public int matrixScore(int[][] grid) {
        int[] counts = new int[grid[0].length];
        // 处理每一行
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[0].length - 1; j>= 0; j--) {
                if (grid[i][0] == 0) {
                    grid[i][j] = grid[i][j] ^ 1;
                }
                if (grid[i][j] == 1) counts[j]++;
            }
        }
        // 处理每一列
        for (int j = 0; j < grid[0].length; j++) {
            if (counts[j] * 2 < grid.length) {
                for (int i = 0; i < grid.length; i++) {
                    grid[i][j] = grid[i][j] ^ 1;
                }
            }
        }
        // 计算结果
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            int temp = 0;
            for (int j = 0; j < grid[0].length; j++) {
                temp = temp * 2 + grid[i][j];
            }
            res += temp;
        }
        return res;
    }
}