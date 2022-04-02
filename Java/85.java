class Solution85 {
    public static int maximalRectangle(char[][] matrix) {
        int[][] left = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] != '1') {left[i][j] = 0; continue;}
                if (j > 0)  left[i][j] = left[i][j - 1] + 1;
                else left[i][j] = 1;
                res = largestRectangleArea(left, i, j) > res ? largestRectangleArea(left, i, j) : res;
            }
        return res;
    }

    public static int largestRectangleArea(int[][] left, int i, int j){
        int area = 0, min = left[0].length;
        // 纵坐标不变，只看横坐标
        for (int m = i; m >= 0; m--){
            min = left[m][j] < min ? left[m][j] : min;
            area = min * (i -m + 1) > area ? min * (i - m + 1) : area;
        }
        return area;
    }
}