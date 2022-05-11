class Solution410 {
    public int splitArray(int[] nums, int m) {
        int[][] dp = new int[nums.length][m]; // dp[i][j]表示到当前位置时候分给成j个数组的值
        int[] sum = new int[nums.length]; // 前缀和
        // 边界，前缀和
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) sum[i] = nums[i];
            else sum[i] = sum[i - 1] + nums[i];
            dp[i][0] = sum[i];
        }
        // dp
        int res = dp[nums.length - 1][0];
        for (int i = 0; i < nums.length; i++) {
            for (int n = 1; n < m; n++) {
                if (n > i) break;
                dp[i][n] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (n - 1 > j) continue;
                    int temp = Math.max(dp[j][n - 1], sum[i] - sum[j]);
                    dp[i][n] = Math.min(dp[i][n], temp);
                    if (i == nums.length - 1 && n == m -1) res = Math.min(res, dp[i][n]);
                }
            }
        }
        return res;
    }
}