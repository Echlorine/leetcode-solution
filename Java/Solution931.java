class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        // dp 为截止到某行某列 这一元素时的最小值
        int[][] dp = new int[matrix.length][matrix[0].length];
        // 初始化
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }
        // 动态规划
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int a = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
                if (j - 1 >= 0) a = dp[i - 1][j - 1];
                if (j + 1 < dp[0].length) c = dp[i - 1][j + 1];
                dp[i][j] = min(a, dp[i - 1][j], c) + matrix[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < dp[0].length; j++) {
            res = Math.min(res, dp[dp.length - 1][j]);
        }
        return res;
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}