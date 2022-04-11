class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, remain = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        remain = sum - target;
        if (remain < 0 || remain % 2 != 0) return 0;
        remain /= 2;
        // 问题转化为从数组中挑 n 个数的和为 remain 的挑法
        int dp[][] = new int[nums.length + 1][remain + 1];
        // 边界条件
        dp[0][0] = 1;
        // dp
        for (int i = 1; i <= nums.length; i++)
            for (int j = 0; j <= remain; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        return dp[nums.length][remain];
    }
}