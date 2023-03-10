import java.util.*;

class Interview1724 {
    public int[] getMaxMatrix(int[][] matrix) {
        int r1 = 0, c1 = 0, r2 = 0, c2 = 0;
        int[] col = new int[matrix[0].length]; // 存储每一列的值
        int[] dp = new int[col.length];
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(col, 0); // 初始化置0
            Arrays.fill(dp, 0); // 初始化置0
            for (int j = i; j < matrix.length; j++) {
                // dp
                int begin = 0;
                col[0] += matrix[j][0]; // 更新 col 矩阵
                dp[0] = col[0];
                maxsum = Math.max(maxsum, dp[0]);
                for (int k = 1; k < col.length; k++) {
                    col[k] += matrix[j][k]; // 更新 col 矩阵
                    if (dp[k - 1] + col[k] > col[k]) {
                        dp[k] = dp[k - 1] + col[k];
                    }
                    else {
                        dp[k] = col[k];
                        begin = k;
                    }
                    if (dp[k] > maxsum) {
                        maxsum = dp[k];
                        c1 = begin;
                        c2 = k;
                        r1 = i;
                        r2 = j;
                    }
                }
            }
        }
        return new int[] {r1, c1, r2, c2};
    }
}
