class Solution1814 {
    public int countNicePairs(int[] nums) {
        final int MOD = 1000000007;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int key = num - rev(num);
            int value = map.getOrDefault(key,0);
            res = (res + value) % MOD;
            map.put(key, ++value);
        }
        return res;
    }

    public int rev(int x) {
        int res = 0;
        while (x >= 10) {
            int temp = x % 10;
            res = res * 10 + temp;
            x = x / 10;
        }
        return res * 10 + x;
    }
}