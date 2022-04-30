class Solution53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length]; // dp[i]表示以nums[i]结尾的最大和
        dp[0] = nums[0]; // 边界
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + dp[i - 1] > nums[i])
                dp[i] = nums[i] + dp[i - 1];
            else
                dp[i] = nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}