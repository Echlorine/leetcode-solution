class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0, fast = slow + 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}