class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (nums.length < 2 || sum % 2 != 0) return false;
        sum /= 2;
        // 0-1背包
        boolean dp[][] = new boolean[nums.length + 1][sum + 1];
        // 边界条件
        dp[0][0] = true;
        // dp
        for (int i = 1; i <= nums.length; i++)
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
            }
        return dp[nums.length][sum];
    }
}