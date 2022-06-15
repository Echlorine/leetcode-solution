class Solution995 {
    public int minKBitFlips(int[] nums, int k) {
        int res = 0;
        int[] diffs = new int[nums.length + 1];
        int flag = 0; // 0 代表不翻, 1 代表翻
        for (int i = 0; i < nums.length; i++) {
            flag ^= diffs[i];
            if (nums[i] == flag) {
                if (i > nums.length - k) return -1;
                res++;
                diffs[i + k] ^= 1;
                flag ^= 1;
            }
        }
        return res;
    }
}