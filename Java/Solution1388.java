class Solution1388 {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length / 3;
        int[][] dp = new int[slices.length][n + 1];
        int[][] fp = new int[slices.length][n + 1];
        // 边界，选了第1个，不能选最后一个
        for (int j = 1; j <= n; j++) {
            dp[0][j] = slices[0];
            dp[1][j] = slices[0];
            fp[0][j] = 0;
            fp[1][j] = slices[1];
        }
        // dp
        for (int i = 2; i < slices.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (i < slices.length - 1) // dp不能选择最后一个
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + slices[i]);
                fp[i][j] = Math.max(fp[i - 1][j], fp[i - 2][j - 1] + slices[i]);
            }
        }
        return Math.max(dp[slices.length - 2][n], fp[slices.length - 1][n]);
    }
}