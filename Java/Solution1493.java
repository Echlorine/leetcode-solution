class Solution1493 {
    public int longestSubarray(int[] nums) {
        int len = 0, res = 0;
        int count = 0; // 标记是否已经将一个 0 变为 1
        int left = 0;
        for (int right = 0; right < nums.length; right++) { // 右移窗口
            if (nums[right] == 1) {
                len++;
            }
            else if (count < 1) {
                len++;
                count++;
            }
            else { // 右边界保持不变，左边界右移
                res = Math.max(res, len);
                if (nums[left] == 0) count--;
                left++;
                right--;
                len--;
            }
        }
        return Math.max(res, len) - 1;
    }
}