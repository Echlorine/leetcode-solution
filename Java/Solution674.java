class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        int slow = 0;
        int res = 1;
        while (slow < nums.length) {
            int fast = slow + 1;
            while (fast < nums.length && nums[fast] > nums[fast - 1]) {
                fast++;
            }
            res = Math.max(res, fast - slow);
            slow = fast;
        }
        return res;
    }
}