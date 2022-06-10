class Solution80 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int count = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[++slow] = nums[fast];
                count = 1;
            }
            else if (nums[fast] == nums[fast - 1]) {
                if (count == 1) {
                    nums[++slow] = nums[fast];
                    count++;
                }
            }
        }
        return slow + 1;
    }
}