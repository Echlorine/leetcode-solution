class Solution312 {
    public int maxCoins(int[] nums) {
        // dp, dp[i][j]表示区间i，j之间所能获得的最大金币数量
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        int temp = 0, left = 0, right = 0;
        // 边界条件,数组初始化时可以省略
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j <= i + 1; j++)
                if (j < dp.length) dp[i][j] = 0;
        // dp
        for (int i = dp.length - 2; i >= 0; i--)
            for (int j = i + 2; j < dp.length; j++) {
                temp = 0;
                for (int k = i + 1; k < j; k++) {
                    // 状态转移
                    if (i < 1 || i > nums.length) left = 1;
                    else left = nums[i - 1];
                    if (j < 1 || j > nums.length) right = 1;
                    else right = nums[j - 1];
                    temp = Math.max(temp, dp[i][k] + dp[k][j] + nums[k - 1] * left * right);
                }
                dp[i][j] = temp;
            }
        return dp[0][nums.length + 1];
    }
}