class Solution73 {
    public void setZeroes(int[][] matrix) {
        boolean row = false, col = false; // 标记第一行或者某一列是否应该为0
        for (int j = 0; j < matrix[0].length; j++)
            row = row || matrix[0][j] == 0;
        for (int i = 0; i < matrix.length; i++)
            col = col || matrix[i][0] == 0;
        // 遍历原数组
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // 同列为0，既记录了同列信息，也记录了自身信息
                    matrix[0][j] = 0; // 同行为0，既记录了同行信息，也记录了自身信息
                }
            }
        }
        // 修改数组
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] ==0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        // 修改第一行与第一列
        if (row) {
            for (int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
        }
        if (col) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
}