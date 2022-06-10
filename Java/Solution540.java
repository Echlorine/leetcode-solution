class Solution540 {
    private int res;

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        res = -1;
        binary_search(nums, 0, nums.length - 1);
        return nums[res];
    }

    public void binary_search(int[] nums, int left, int right) {
        if (left > right) return;
        int mid = (left + right) / 2;
        if (mid > 0 && mid < nums.length - 1 && nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {res = mid; return;}
        if (mid == 0 && nums[mid] != nums[mid + 1]) {res = mid; return;}
        if (mid == nums.length - 1 && nums[mid] != nums[mid - 1]) {res = mid; return;}
        binary_search(nums, left, mid - 1);
        binary_search(nums, mid + 1, right);
    }
}