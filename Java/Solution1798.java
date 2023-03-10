class Solution1798 {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int max = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= max + 1) {
                max += coins[i];
            }
            else break;
        }
        return max + 1;
    }
}