class Solution152 {
    public int maxProduct(int[] nums) {
        int[] dpmax = new int[nums.length];
        int[] dpmin = new int[nums.length];
        int res = nums[0];
        // 边界条件
        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        // 动态规划
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > 0) {dpmax[i] = Math.max(dpmax[i - 1] * nums[i], nums[i]); dpmin[i] = Math.min(dpmin[i - 1] * nums[i], nums[i]);}
            if (nums[i] < 0) {dpmax[i] = Math.max(dpmin[i - 1] * nums[i], nums[i]); dpmin[i] = Math.min(dpmax[i - 1] * nums[i], nums[i]);}
            if (nums[i] == 0) {dpmax[i] = 0; dpmin[i] = 0;}
            res = Math.max(res, dpmax[i]);
        }
        return res;
    }
}