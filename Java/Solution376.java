class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        int[][] dp = new int[nums.length][2];
        // 边界
        dp[0][0] = 1; dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = 1; dp[i][1] = 1;
            for (int j = i; j >= 0; j--) {
                if (nums[j] < nums[i])
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                else if (nums[j] > nums[i])
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                else {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0]);
                    dp[i][1] = Math.max(dp[i][1], dp[j][1]);
                }
            }
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}