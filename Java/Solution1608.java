import java.util.Arrays;

class Solution1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int left = 1, right = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == 0) return nums[nums.length - 1] < 0 ? 0 : -1;
            if (mid == nums.length) return nums[0] >= mid ? mid : -1;
            if (nums[nums.length - mid] < mid) {
                right = mid - 1;
            } else {
                if (nums[nums.length - mid -1] < mid) return mid;
                else left = mid + 1;
            }
        }
        return -1;
    }
}