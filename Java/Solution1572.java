class Solution1572 {
    public int diagonalSum(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            // 主对角线
            int a = mat[i][i];
            // 副对角线
            int b = mat[i][mat.length - 1 - i];
            if (i + i == mat.length - 1) {res += a;}
            else {
                res += a;
                res += b;
            }
        }
        return res;
    }
}