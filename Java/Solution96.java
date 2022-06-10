class Solution96 {
    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n + 1; i++) // 计算Gn
            for (int j = 1; j <= i; j++)
                res[i] += res[j - 1] * res[i - j];
        return res[n];
    }
}