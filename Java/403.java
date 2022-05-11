class Solution403 {
    public boolean canCross(int[] stones) {
        boolean[][] dp = new boolean[stones.length][stones.length];
        // 边界
        dp[0][0] = true;
        // 预判断
        for (int i = 1; i < stones.length; i++) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        // dp
        for (int i = 1; i < stones.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j]; // 上一步走的步数
                if (k > j + 1) break;
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == stones.length - 1 && dp[i][k]) return true;
            }
        }
        return false;
    }
}