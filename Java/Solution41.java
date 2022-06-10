class Solution41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] <= 0) nums[i] = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] >= 0 ? nums[i] : -nums[i];
            if (index >= 1 && index <= nums.length) nums[index - 1] = nums[index - 1] > 0 ? -nums[index - 1] : nums[index - 1];
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0) return i + 1;
        return nums.length + 1;
    }
}