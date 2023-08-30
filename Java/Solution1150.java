class Solution1150 {
    public boolean isMajorityElement(int[] nums, int target) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        // 左边界
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        int l = ans;
        // 右边界
        left = 0;
        right = nums.length - 1;
        ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        int r = ans;
        return (r - l) > (nums.length / 2);
    }
}