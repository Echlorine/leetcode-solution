class Solution712 {
    public int minimumDeleteSum(String s1, String s2) {
        // 把总码表大的作为目标，另一个作为源字符串
        // 保持目标串不变，源字符串可以增加字符或者删除字符
        int ascii_s1 = 0, ascii_s2 = 0;
        for (int i = 0; i < s1.length() || i < s2.length(); i++) {
            if (i < s1.length()) ascii_s1 += s1.charAt(i);
            if (i < s2.length()) ascii_s2 += s2.charAt(i);
        }
        String target = "";
        String source = "";
        if (ascii_s1 < ascii_s2) {
            target = s2;
            source = s1;
        } else {
            target = s1;
            source = s2;
        }
        int[][] dp = new int[target.length() + 1][source.length() + 1];
        // 初始化边界
        for (int j = 1; j <= source.length(); j++) {
            dp[0][j] = dp[0][j - 1] + source.charAt(j - 1);
        }
        for (int i = 1; i <= target.length(); i++) {
            dp[i][0] = dp[i - 1][0] + target.charAt(i - 1);
        }
        // dp
        for (int i = 1; i <= target.length(); i++) {
            for (int j = 1; j <= source.length(); j++) {
                if (target.charAt(i - 1) == source.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + source.charAt(j - 1), dp[i - 1][j] + target.charAt(i - 1));
                }
            }
        }
        return dp[target.length()][source.length()];
    }
}