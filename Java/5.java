class Solution5 {
    public static String longestPalindrome(String s) {
        int len;
        len = s.length(); //增值矩阵的维度
        if (len == 1)
            return s;
        int begin=0,maxlen=1;
        boolean [][]dp = new boolean[len][len];
        for (int i=0; i<len; i++)
            dp[i][i] = true;
        char []sarray = s.toCharArray();
        for (int l=2; l<=len;l++){ //l为子串长度
            for (int i=0; i<len; i++){ //i为左边界
                int j = i+l-1; //右边界
                if (j >= len)
                    break; //越界退出循环
                if (sarray[i] != sarray[j])
                    dp[i][j] = false;
                else if (l<4)
                    dp[i][j] = true;
                else
                    dp[i][j] = dp[i+1][j-1]; //状态转移方程
                if (l > maxlen && dp[i][j] == true){
                    maxlen = l;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxlen);
    }
}
