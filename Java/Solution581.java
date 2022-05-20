class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < nums.length) {
            if (nums[left] <= nums[left + 1]) left++;
            else break; 
        }
        while (right - 1 >= 0) {
            if (nums[right] >= nums[right - 1]) right--;
            else break;
        }
        if (right < left) return 0;
        int min = nums[left], max = nums[right];
        for (int i = left; i <= right; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }
        while (left >= 1){
            if (nums[left - 1] > min) left--;
            else break;
        }
        while (right < nums.length - 1) {
            if (nums[right + 1] < max) right++;
            else break;
        }
        return nums.length == 1 ? 0 : right - left + 1;
    }
}