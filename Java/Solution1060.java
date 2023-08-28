class Solution1060 {
    public int missingElement(int[] nums, int k) {
        int[] diff = new int[nums.length + 1];
        diff[0] = 0;
        diff[nums.length] = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            diff[i] = diff[i - 1] + nums[i] - nums[i - 1] - 1;
        }
        int left = 0, right = diff.length - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (diff[mid] < k) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return nums[left] + k - diff[left];
    }
}