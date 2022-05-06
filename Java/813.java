class Solution813 {
    public double largestSumOfAverages(int[] nums, int k) {
        double[][] dp = new double[nums.length][k];
        double[] sum = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) sum[0] = nums[0];
            else sum[i] += sum[i - 1] + nums[i];
            dp[i][0] = sum[i] / (i + 1);
        }
        double res = dp[nums.length - 1][0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                for (int n = 1; n < k; n++) {
                    if (n > i) break;
                    dp[i][n] = Math.max(dp[i][n], dp[j][n - 1] + (sum[i] - sum[j]) / (i - j));
                    if (i == nums.length - 1)
                        res = Math.max(res, dp[i][n]);
                }
            }
        }
        return res;
    }
}