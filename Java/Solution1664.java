class Solution1664 {
    public int waysToMakeFair(int[] nums) {
        int odd = 0, even = 0;
        for(int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) even += nums[i];
            else odd += nums[i];
        }
        int pre_odd = 0, pre_even = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // 删掉 nums[i]
            if (i % 2 == 0) pre_even += nums[i];
            else pre_odd += nums[i];
            // 计算当前位置后面的奇数
            int a = even - pre_even + pre_odd;
            // 计算偶数
            int b = odd - pre_odd + pre_even;
            if (i % 2 == 0) b -= nums[i];
            else a -= nums[i];
            if (a == b) res++;
        }
        return res;
    }
}