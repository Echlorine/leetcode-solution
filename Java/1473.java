class Solution1473 {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n][target]; // dp[i][k][t]表示给第i个房子涂上颜色k之后，此时街区数量为t，所用的最小花费
        // 边界
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                for (int t = 0; t < target; t++) {
                    if (i == 0 && t <= i) {
                        if (houses[i] != 0) // 当前墙壁被粉刷过
                            dp[i][k][t] = houses[i] - 1 == k ? 0 : Integer.MAX_VALUE / 2; // 是我们需要的颜色则cost为0，否则是无穷大
                        else dp[i][k][t] = cost[i][k]; // 没被粉刷过就是正常花费
                    }
                    else
                        dp[i][k][t] = Integer.MAX_VALUE / 2;
                }
            }
        }
        // dp
        for (int i = 1; i < m; i++) {
            for (int k = 0; k < n; k++) {
                for (int t = 0; t < target; t++) {
                    if (houses[i] != 0 ) { // 当前房屋已被粉刷过
                        if (houses[i] - 1 == k) { // 当前房屋颜色和需要的颜色相同
                            for (int h = 0; h < n; h++) {
                                if (h == k) // 当前房屋与前一个房屋颜色相同，均为k
                                    dp[i][k][t] = Math.min(dp[i][k][t], dp[i - 1][k][t]);
                                else if (t > 0) // 当前房屋与前一个房屋颜色不同
                                    dp[i][k][t] = Math.min(dp[i][k][t], dp[i - 1][h][t - 1]);
                            }
                        }
                        else dp[i][k][t] = Integer.MAX_VALUE / 2; // 当前房屋颜色和需要的颜色不同
                    }
                    else { // 当前房屋没被粉刷过
                        for (int h = 0; h < n; h++) {
                            if (h == k) // 当前房屋与前一个房屋颜色相同，均为k
                                dp[i][k][t] = Math.min(dp[i][k][t], dp[i - 1][k][t] + + cost[i][k]);
                            else if (t > 0) // 当前房屋与前一个房屋颜色不同
                                dp[i][k][t] = Math.min(dp[i][k][t], dp[i - 1][h][t - 1] + cost[i][k]);
                        }
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE / 2;
        for (int k = 0; k < n; k++) {
            res = Math.min(res, dp[m - 1][k][target - 1]);
        }
        return res == Integer.MAX_VALUE / 2 ? -1 : res;
    }
}