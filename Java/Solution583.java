class Solution583 {
    public int minDistance(String word1, String word2) {
        // dp[i][j]表示 word1 的前 i 个字符和 word2 的前 j 个字符的最大公共长度
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 边界
        // dp
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return word1.length() + word2.length() - dp[word1.length()][word2.length()] - dp[word1.length()][word2.length()];
    }
}