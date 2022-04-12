class Solution1230 {
    public double probabilityOfHeads(double[] prob, int target) {
        double[][] res = new double[prob.length + 1][target + 1];
        // 边界
        res[0][0] = 1;
        // dp
        for (int i = 1; i <= prob.length; i++)
            for (int j = 0; j <= target; j++) {
                if (j > i) {res[i][j] = 0; break;}
                res[i][j] = res[i - 1][j] * (1 - prob[i - 1]);
                if (j > 0) res[i][j] += res[i - 1][j - 1] * prob[i - 1];
            }
        return res[prob.length][target];
    }
}