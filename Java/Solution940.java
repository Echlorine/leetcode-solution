class Solution {
    public int distinctSubseqII(String s) {
        int[] hash = new int[26];
        int mod = 1000000007;
        // 确定每个字符的最后一个位置
        for (int i = s.length() - 1; i>= 0; i--) {
            char c = s.charAt(i);
            if (hash[c - 'a'] == 0 && i != 0) hash[c - 'a'] = i;
        }
        // dp
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i) - 'a'] == 0 && i != 0) {
                dp[i] = 1;
            }
            else {
                int temp = 0;
                for (int j = 0; j < i; j++) {
                    if (s.charAt(j) != s.charAt(i)) {
                        temp = (temp + dp[j]) % mod;
                    }
                }
                dp[i] = 1 + temp;
            }
            res = (res + dp[i]) % mod;
        }
        return res;
    }
}