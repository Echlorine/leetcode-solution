class Solution788 {

    private int[] flag;

    public int rotatedDigits(int n) {
        flag = new int[n + 1]; // 0表示不能翻转，1表示可以翻转但不是好数，2表示是好数
        // dp[i] 表示从1到i中有多少个好数
        int[] dp = new int[n + 1];
        flag[0] = 1;
        dp[0] = 0;
        for (int i = 1; i <=n; i++) {
            int k = isGoodDigits(i);
            if (k == 2) dp[i] = dp[i - 1] + 1;
            else dp[i] = dp[i - 1];
        }
        return dp[n];
    }

    public int isGoodDigits(int n) {
        int temp = n / 10, sfx = n % 10;
        if (flag[temp] == 2) {
            if (sfx == 3 || sfx == 4 || sfx == 7) flag[n] = 0;
            else flag[n] = 2;
        } else if (flag[temp] == 1) {
            if (sfx == 3 || sfx == 4 || sfx == 7) flag[n] = 0;
            else if (sfx == 0 || sfx == 1 || sfx == 8) flag[n] = 1;
            else flag[n] = 2;
        } else flag[n] = 0;
        return flag[n];
    }
}