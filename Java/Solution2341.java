class Solution2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] hash = new int[101];
        int n = 0;
        for (int num : nums)
            hash[num]++;
        for (int i = 0; i <= 100; i++) {
            if (hash[i] % 2 == 1) n++;
        }
        return new int[]{(nums.length - n) / 2, n};
    }
}