import java.util.*;

class Solution1478 {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int[][] costs = new int[houses.length][houses.length];
        for (int i = houses.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < houses.length; j++) {
                costs[i][j] = costs[i + 1][j - 1] + houses[j] - houses[i];
            }
        }
        int[][] dp = new int[houses.length][k];
        // dp
        for (int i = 0; i < houses.length; i++) {
            // 边界，只有一个邮筒
            if (i == 0) dp[i][0] = 0;
            else dp[i][0] = costs[0][i];
            for (int j = 1; j < k; j++) {
                if (j > i) break; // 邮筒数量不会超过房屋数量
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = 0; m < i; m++) {
                    if (j - 1 > m) continue; // 邮筒数量不会超过房屋数量
                    dp[i][j] = Math.min(dp[i][j], dp[m][j - 1] + costs[m + 1][i]);
                }
            }
        }
        return dp[houses.length - 1][k - 1];
    }
}