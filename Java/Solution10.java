class Solution10 {
    public boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        boolean[][] res = new boolean[len1 + 1][len2 + 1];
        // 边界条件
        res[0][0] = true;
        // 动态规划
        for (int i = 0; i <= len1; i++)
            for (int j = 1; j <= len2; j++){
                if (p.charAt(j - 1) != '.' && p.charAt(j - 1) != '*'){
                    if (i != 0)
                        res[i][j] = res[i - 1][j - 1] && p.charAt(j - 1) == s.charAt(i - 1);
                }
                if (p.charAt(j - 1) == '.'){
                    if (i != 0)
                        res[i][j] = res[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*'){
                    res[i][j] = res[i][j - 2];
                    if (i != 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'))
                        res[i][j] = res[i - 1][j] || res[i][j - 2];
                }
            }
        return res[len1][len2];
    }
}