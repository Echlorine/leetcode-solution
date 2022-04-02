class Solution198 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0]; // 特例
        // 动态规划
        int[] dp = new int[nums.length];
        int res = Math.max(nums[0], nums[1]);
        // 边界条件
        dp[0] = nums[0];
        dp[1] = res;
        for (int i = 2; i < nums.length; i++){
            dp[i] = Math.max(res, nums[i] + dp[i - 2]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}