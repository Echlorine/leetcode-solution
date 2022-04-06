class Solution338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        // 每一个等于最接近的幂次相加
        res[0] = 0;
        for (int i = 1; i < res.length; i++) {
            res[i] = i % 2 + res[i / 2];
        }
        return res;
    }
}