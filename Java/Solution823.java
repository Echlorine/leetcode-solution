class Solution823 {
    public int numFactoredBinaryTrees(int[] arr) {
        long mod = 1000000007;
        Arrays.sort(arr);
        long[] dp = new long[arr.length];
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = 0, right = i;
            dp[i] = 1;
            while(left <= right) {
                if (arr[left] * arr[right] < arr[i]) {
                    left++;
                } else if (arr[left] * arr[right] > arr[i]) {
                    right--;
                } else {
                    if (left != right) dp[i] = (dp[i] + dp[left] * dp[right] *2) % mod;
                    else dp[i] = (dp[i] + dp[left] * dp[right]) % mod;
                    left++;
                }
            }
            res = (res + dp[i]) % mod;
        }
        return (int) res;
    }
}