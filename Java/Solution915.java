class Solution915 {
    public int partitionDisjoint(int[] nums) {
        int[] lmax = new int[nums.length];
        int[] rmin = new int[nums.length];
        lmax[0] = nums[0]; rmin[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            lmax[i] = Math.max(lmax[i - 1], nums[i]);
            rmin[nums.length - 1 - i] = Math.min(rmin[nums.length - i], nums[nums.length - 1 - i]);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (lmax[i] <= rmin[i + 1]) return i + 1;
        }
        return nums.length;
    }
}