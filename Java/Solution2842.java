class Solution2842 {
    private long res = 0;
    private int mod = 1000000007;
    private int[] nums = new int[26];

    private long sum = 0; // 美丽值
    private int k;

    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        this.k = k;
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        dfs(0, 0, 0, 1);
        return (int) res;
    }

    public void dfs(int index, int len, long value, long mul) {
        /*
        index : 当前下标
        len : 当前子序列长度
        n : 美丽值
        mul : 数量
         */
        // 递归出口
        if (len == k) {
            if (value > sum) {
                sum = value; // 更新最大美丽值
                res = mul % mod;
            } else if (value == sum) {
                res = (res + mul) % mod;
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            dfs(i + 1, len + 1, value + nums[i], (mul * nums[i]) % mod);
        }
    }
}