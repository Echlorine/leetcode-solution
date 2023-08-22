class Solution2681 {
    private long res;
    private int mod = 1000000007;

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return (int) (res % mod);
    }

    public void dfs(int[] nums, int index, List<Integer> ans) {
        if (index == nums.length) {
            // 计算这一组的力量
            if (ans.size() == 0) return;
            int m = ans.get(ans.size() - 1), n = ans.get(0);
            res = (int) ((res + 1L * m * m % mod * n) % mod);
            return;
        }
        // 不选择当前结点
        dfs(nums, index + 1, ans);
        // 选择当前结点
        ans.add(nums[index]);
        dfs(nums, index + 1, ans);
        ans.remove(ans.size() - 1);
    }
}

class Solution2681 {

    private int mod = 1000000007;

    public int sumOfPower(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] dp_sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = (dp_sum[i] + nums[i]) % mod;
            dp_sum[i + 1] = (dp_sum[i] + dp[i]) % mod;
            res = (int) ((res + 1L * nums[i] * nums[i] % mod * dp[i]) % mod);
        }
        return res % mod;
    }
}