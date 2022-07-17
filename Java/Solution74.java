class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 整体二分查找
        int begin = 0, end = m * n - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            int x = mid / n, y = mid % n;
            if (matrix[x][y] == target) return true;
            else if (matrix[x][y] > target) {
                end = mid - 1;
            }
            else {
                begin = mid + 1;
            }
        }
        return false;
    }
}