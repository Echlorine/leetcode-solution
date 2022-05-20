class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (matrix[m - 1][n - 1] < target) return false;
        for (int i = 0; i < m; i++)
            if (matrix[i][0] <= target && matrix[i][n - 1] >= target)
                if (find(matrix, target, i, 0, n - 1)) return true;
        return false;
    }

    public boolean find (int[][] matrix, int target, int i, int begin, int end) {
        // 每一行进行二分查找
        if (begin <= end) {
            int k = matrix[i][(begin + end) / 2];
            if (k > target) return find(matrix, target, i, begin, (begin + end) / 2 - 1);
            if (k == target) return true;
            if (k < target)  return find(matrix, target, i, (begin + end) / 2 + 1, end);
            return false;
        }
        else return false;
    }
}