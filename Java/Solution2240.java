class Solution2240 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        for (int i = 0; cost1 * i <= total; i++) {
            int t = total - cost1 * i;
            res += t / cost2 + 1;
        }
        return res;
    }
}