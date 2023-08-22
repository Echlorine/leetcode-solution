class Solution1289 {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = Integer.MAX_VALUE;
        int first_min = Integer.MAX_VALUE, second_min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < m; i++) {
            int f = Integer.MAX_VALUE, s = Integer.MAX_VALUE;
            int id = -1;
            for (int j = 0; j < n; j++) {
                int t = 0;
                if (i == 0) {
                    t = grid[i][j];
                } else {
                    if (j != index) t = first_min + grid[i][j];
                    else t = second_min + grid[i][j];
                }
                // 更新最小值、次小值
                if (t < f) {
                    s = f;
                    f = t;
                    id = j;
                } else if (t < s && t >= f) {
                    s = t;
                }
                if (i == m - 1) {
                    res = Math.min(res, t);
                }
            }
            first_min = f;
            second_min = s;
            index = id;
        }
        return res;
    }
}