class Solution300 {
    public int lengthOfLIS(int[] nums) {
        // dp
        int[] dp = new int[nums.length];
        // 边界条件
        dp[0] = 1;
        int temp = 0, res = dp[0];
        // dp
        for (int i = 1; i < nums.length; i++){
            temp = 1;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    temp = Math.max(temp, dp[j]);
            dp[i] = temp + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}