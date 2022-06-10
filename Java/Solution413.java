class Solution413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length]; // dp[i]表示以 nums[i] 作为等差数列结尾的子数组的个数
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            dp[i] = nums[i - 1] + nums[i - 1] == nums[i - 2] + nums[i] ? dp[i - 1] + 1 : 0;
            res += dp[i];
        }
        return res;
    }
}