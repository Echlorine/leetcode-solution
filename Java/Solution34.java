class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int l = binarySearchLeft(nums, target);
        int r = binarySearchRight(nums, target);
        if (l <= r && r < nums.length && nums[l] == target && nums[r] == target) {
            return new int[] {l, r};
        }
        return new int[] {-1, -1};
    }

    public int binarySearchLeft(int [] nums, int target) {
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
        return ans;
    }

    public int binarySearchRight(int [] nums, int target) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans - 1;
    }
}