class Solution162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid > 0 && mid < nums.length - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
                else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) left = mid + 1;
                else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) right = mid - 1;
                else left++;
            }
            else if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) return mid;
                else left = mid + 1;
            }
            else {
                if (nums[mid] > nums[mid - 1]) return mid;
                else right = mid - 1;
            }
        }
        return  -1;
    }
}