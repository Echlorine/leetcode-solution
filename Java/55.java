class Solution55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true; // 特例
        boolean[] dp = new boolean[nums.length];
        // 边界条件
        if (nums[nums.length - 1] >= 1) dp[nums.length - 1] = true;
        else dp[nums.length - 1] = false;
        for (int i = nums.length - 2; i >= 0; i--)
            for (int j = 1; j <= nums[i]; j++){
                if (i + j < nums.length - 1) dp[i] = dp[i] || dp[i + j];
                else {dp[i] = true; break;}
            }
        return dp[0];
    }
}