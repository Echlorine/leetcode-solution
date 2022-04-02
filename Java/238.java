class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] la = new int[nums.length], ra = new int [nums.length];
        int[] res = new int[nums.length];
        la[0] = 1;
        ra[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            la[i] = nums[i - 1] * la[i - 1];
            ra[nums.length - 1 - i] = nums[nums.length - i] * ra[nums.length - i];
        }
        for (int i = 0; i < nums.length; i++)
            res[i] = la[i] * ra[i];
        return res;
    }
}