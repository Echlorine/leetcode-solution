class Solution300 {
    public int dplengthOfLIS(int[] nums) {
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

    public int greedylengthOfLIS(int[] nums) {
        int[] len = new int[nums.length + 1]; // len[j] 表示前 i 个元素可以组成的长度为 j 的最长严格递增子序列的末尾元素的最小值
        len[0] = 0; len[1] = nums[0]; // 初始化
        int res= 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > len[res]) {
                res++;
                len[res] = nums[i];
            }
            else {
                len[binaryserarch(len, res, nums[i])] = nums[i];
            }
        }
        return res;
    }

    public int binaryserarch(int[] len, int end, int target) {
        int left = 0;
        int right = end;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (len[mid] < target)
                left = mid;
            else
                right = mid;
        }
        return left + 1;
    }
}