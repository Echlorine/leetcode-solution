class LCP06 {
    public int minCount(int[] coins) {
        int res = 0;
        for (int coin : coins) {
            res += (coin + 1) / 2;
        }
        return res;
    }
}