class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        while (target - numbers[i] >= numbers[i]) {
            int res = binary_search(numbers, i, target - numbers[i]);
            if (res != -1) return new int[] {i + 1, res + 1};
            i++;
        }
        return new int[] {};
    }

    public int binary_search(int[] nums, int index, int target) {
        int left = index + 1, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}