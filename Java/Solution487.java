class Solution487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = 0, res = 0;
        int count = 1; // 标记是否已经将一个 0 变为 1
        int left = 0, last = 0;
        for (int right = 0; right < nums.length; right++) { // 右移窗口
            if (nums[right] == 1) {
                len++;
            }
            else if (count == 1) {
                len++;
                last = right;
                count = 0;
            }
            else {
                res = Math.max(res, len);
                left = last + 1;
                len = right - left;
                count = 1;
                right--;
            }
        }
        return Math.max(res, nums.length - left);
    }
}