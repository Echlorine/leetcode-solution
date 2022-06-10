class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int res = nums.length + 1;
        for (int i = nums.length; i>= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (sum[i] - sum[j] >= target) {
                    res = Math.min(res, i - j);
                    break;
                }
            }
        }
        return res > nums.length ? 0 : res;
    }

    public int swminSubArrayLen(int target, int[] nums) {
        /**
         * 用滑动窗口解决
         */
        int left = 0, right = 0;
        int res = nums.length + 1;
        int sum = nums[0];
        while (right < nums.length) {
            if (sum >= target) {
                res = Math.min(res, right - left + 1);
                // 窗口左移
                left++;
                sum -= nums[left - 1];
            }
            else {
                if (right < nums.length - 1)
                    sum += nums[++right];
                else {
                    if (sum < target) break;
                }
            }
        }
        return res > nums.length ? 0 : res;
    }
}