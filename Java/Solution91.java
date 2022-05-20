class Solution91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()]; // dp[i] 表示以第 i 个字符结尾的编码总数
        // 边界
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        if (s.length() > 1) {
            int temp = Integer.valueOf(s.substring(0, 2));
            if (temp < 10 || (temp > 26 && temp % 10 == 0)) return 0;
            else if (temp == 10 || temp == 20) dp[1] = 1;
            else if (temp > 26) dp[1] = 1;
            else dp[1] = dp[0] + 1;
        }
        // dp
        for (int i = 2; i < s.length(); i++) {
            int temp = Integer.valueOf(s.substring(i - 1, i + 1));
            if (temp == 0 || (temp > 26 && temp % 10 == 0)) return 0; // 00
            else if (temp > 0 && temp < 10) dp[i] = dp[i - 1];
            else if (temp == 10 || temp == 20) dp[i] = dp[i - 2];
            else if (temp > 26) dp[i] = dp[i - 1];
            else dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[s.length() - 1];
    }
}