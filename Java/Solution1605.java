class Solution1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            int row = rowSum[i];
            for (int j = 0; row > 0 && j < colSum.length; j++) {
                res[i][j] = Math.min(row, colSum[j]);
                row -= res[i][j];
                colSum[j] -= res[i][j];
            }
        }
        return res;
    }
}