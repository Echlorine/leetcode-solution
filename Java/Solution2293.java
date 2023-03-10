class Solution2293 {
    public int minMaxGame(int[] nums) {
        if (nums.length == 1) return nums[0]; // 递归出口
        int[] newNums = new int[nums.length / 2];
        for (int i = 0; i < newNums.length; i++) {
            if (i % 2 == 0) newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            else newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
        }
        return minMaxGame(newNums);
    }
}