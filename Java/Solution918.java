class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {
        int[] dp = new int[nums.length]; // dp[i]表示以nums[i]结尾的最大和
        int[] lsum = new int[nums.length];
        int[] rsum = new int[nums.length];
        dp[0] = nums[0];
        lsum[0] = nums[0];
        rsum[nums.length - 1] = nums[nums.length - 1]; // 边界
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + dp[i - 1] > nums[i])
                dp[i] = nums[i] + dp[i - 1];
            else
                dp[i] = nums[i];
            lsum[i] = nums[i] + lsum[i - 1];
            rsum[nums.length - 1 - i] = nums[nums.length - 1 - i] + rsum[nums.length - i];
        }
        int[] lp = new int[nums.length];
        int[] rp = new int[nums.length];
        lp[0] = lsum[0];
        rp[nums.length - 1] = rsum[nums.length - 1];
        int lmax = lp[0];
        int rmax = rp[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            lp[i] = Math.max(lmax, lsum[i]);
            lmax = lp[i];
            rp[nums.length - 1 - i] = Math.max(rmax, rsum[nums.length - 1 - i]);
            rmax = rp[nums.length - 1 - i];
        }
        int res = dp[0];
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1)
                dp[i] = Math.max(dp[i], lp[i] + rp[i + 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}