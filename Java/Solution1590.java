class Solution1590 {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        int res = nums.length;
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % p;
        }
        int s = sum;
        if (s == 0) return 0;
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            hashmap.put(sum, i);
            sum = (sum + nums[i]) % p;
            if (hashmap.containsKey((sum - s + p) % p)) {
                res = Math.min(res, i - hashmap.get((sum - s + p) % p) + 1);
            }
        }
        return res == nums.length ? -1 : res;
    }
}