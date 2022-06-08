class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int len = 0, res = 0;
        int count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) { // 右边界右移
            if (nums[right] == 1) {
                len++;
            }
            else if (count < k) {
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
        return Math.max(res, len);
    }
}