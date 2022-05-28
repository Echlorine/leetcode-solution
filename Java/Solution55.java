class Solution55 {
    public boolean canJump(int[] nums) {
        /**
         * 动态规划写法
         */
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

    public boolean greedycanJump(int[] nums) {
        /**
         * 贪心写法
         */
        int len = nums.length - 1;
        int arrival = 0;
        for (int i = 0; i <= len; i++) {
            if (arrival >= i) {
                arrival = Math.max(arrival, i + nums[i]);
                if (arrival >= len) return true;
            }
        }
        return false;
    }
}