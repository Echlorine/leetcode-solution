class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[right]) > Math.abs(nums[left])) {
                res[i] = nums[right] * nums[right];
                right--;
            }
            else {
                res[i] = nums[left] * nums[left];
                left++;
            }
        }
        return res;
    }
}