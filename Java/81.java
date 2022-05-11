class Solution81 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1; 
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true; // 找到目标值
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) { // 不确定在哪一段
                left++;
                right--;
            }
            else if (nums[left] <= nums[mid]) { // 当前部分数组有序
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else { // 包含旋转点
                if (nums[mid] < target && nums[nums.length - 1] >= target) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}