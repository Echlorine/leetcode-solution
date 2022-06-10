class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int[] presum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            presum[i + 1] = presum[i] + cardPoints[i];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            // i 代表左半部分窗口大小
            int sum = presum[i] + presum[len] - presum[len - k + i];
            res = Math.max(res, sum);
        }
        return res;
    }
}