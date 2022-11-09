class Solution87 {
    private String s1;
    private String s2;
    private int[][][] dp;

    public boolean isScramble(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        int length = s1.length();
        // dp 表示
        this.dp = new int[length][length][length + 1];
        return dfs(0, 0, length);
    }

    public boolean dfs(int index1, int index2, int len) {
        if (dp[index1][index2][len] != 0) {
            return dp[index1][index2][len] == 1;
        }
        // s1 == s2
        if (s1.substring(index1, index1 + len).equals(s2.substring(index2, index2 + len))) {
            dp[index1][index2][len] = 1;
            return true;
        }
        // s1 和 s2 的字母数量不一样
        if (!checkNum(index1, index2, len)) {
            dp[index1][index2][len] = -1;
            return false;
        }
        // s1 和 s2 的字母数量一样，需要分情况讨论
        for (int i = 1; i < len; i++) {
            // 不需要交换
            if (dfs(index1, index2, i) && dfs(index1 + i, index2 + i, len - i)) {
                dp[index1][index2][len] = 1;
                return true;
            }
            // 需要交换
            if (dfs(index1, index2 + len - i, i) && dfs(index1 + i, index2, len - i)) {
                dp[index1][index2][len] = 1;
                return true;
            }
        }
        dp[index1][index2][len] = -1;
        return false;
    }

    public boolean checkNum(int index1, int index2, int len) {
        int[] counts = new int[26];
        for (int i = 0; i < len; i++) {
            char c1 = s1.charAt(index1 + i);
            char c2 = s2.charAt(index2 + i);
            counts[c1 - 'a']++;
            counts[c2 - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}