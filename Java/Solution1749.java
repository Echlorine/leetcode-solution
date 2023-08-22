class Solution1749 {
    public int maxAbsoluteSum(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = Math.max(nums[0], 0);
        dp[0][1] = Math.min(nums[0], 0);
        int max = dp[0][0], min = dp[0][1];
        for (int i = 1; i < nums.length; i++) {
            // 大于 0 尽可能大
            dp[i][0] = Math.max(dp[i - 1][0] + nums[i], nums[i]);
            // 小于 0 尽可能小
            dp[i][1] = Math.min(dp[i - 1][1] + nums[i], nums[i]);
            max = Math.max(dp[i][0], max);
            min = Math.min(dp[i][1], min);
        }
        return Math.max(max, -min);
    }
}