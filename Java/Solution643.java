class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = Integer.MIN_VALUE, temp = 0;
        for (int i = 0; i < k; i++)
            temp += nums[i];
        sum = temp;
        for (int i = 1; i <= nums.length - k; i++) {
            temp += nums[i - 1 + k] - nums[i - 1];
            sum = Math.max(sum, temp);
        }
        return (double) (sum) / k;
    }
}