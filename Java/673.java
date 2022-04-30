class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length]; // dp 为包含当前结点的最长子序列的长度
        int[] lp = new int[nums.length]; // dp 为包含当前结点的最长子序列的个数
        int maxlen = 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1; lp[i] = 1; // 边界条件
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        lp[i] = lp[j];
                        continue;
                    }
                    if (dp[j] + 1 == dp[i])
                        lp[i] += lp[j];
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        for (int i = 0; i < nums.length; i++)
            if (dp[i] == maxlen)
                res += lp[i];
        return res;
    }
}