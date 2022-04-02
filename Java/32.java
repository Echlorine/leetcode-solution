class Solution32 {
    public static int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];
        char[] sarray = s.toCharArray();
        
        for (int i = 0; i < len; i++){
            // 初始化不符合条件的值
            if (sarray[i] == '(' || i == 0) dp[i] = 0;
            // 初始化边界
            if (i == 1 && sarray[i] == ')')
                if (sarray[i - 1] == '(') dp[i] = 2;
                else dp[i] = 0;
            // 动态规划
            if (i > 1 && sarray[i] == ')'){
                if (sarray[i - 1] == '(') dp[i] = dp[i - 2] + 2;
                else
                    if (i - dp[i - 1] - 1 >= 0 && sarray[i - dp[i - 1] - 1] == '(')
                    if (i - dp[i - 1] - 2 >= 0) dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    else dp[i] =  dp[i - 1] + 2;
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++)
            if (dp[i] > max) max = dp[i];
        return max;
    }
}

// ()()()
// ()(())
// ()()()( ((()))() )