class Solution213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0]; // 特例
        // 动态规划
        int[] dp = new int[nums.length], fp = new int[nums.length];
        // 边界条件
        dp[0] = nums[0]; dp[1] = nums[0];
        int resd = nums[0];
        for (int i = 2; i < nums.length - 1; i++){
            dp[i] = Math.max(resd, nums[i] + dp[i - 2]);
            resd = Math.max(dp[i], resd);
        }
        fp[0] = 0; fp[1] = nums[1];
        int resf = fp[1];
        for (int i = 2; i < nums.length; i++){
            fp[i] = Math.max(resf, nums[i] + fp[i - 2]);
            resf = Math.max(fp[i], resf);
        }
        return Math.max(resd, resf);
    }
}