class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) len++;
            else {
                res = Math.max(res, len);
                len = 0;
            }
        }
        return Math.max(res, len);
    }
}