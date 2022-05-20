class Solution48 {
    public void rotate(int[][] matrix){
        for (int i = 0, index = 0; i < matrix.length / 2; i++, index++)
            prorate(matrix, index);
    }

    public void prorate(int[][] matrix, int index){
        int begin = index;
        int len = matrix.length - 2 * index; //要旋转的剩余部分的位置
        
        if (len ==0 || len == 1) return;
        int[] temp = new int[len];
        // 暂存上面的代码
        for (int i = begin; i < begin + len; i++)
            temp[i - begin] = matrix[begin][i];
        // 左边转到上面
        for (int i = begin; i < begin + len; i++)
            matrix[begin][i] =  matrix[matrix.length - 1 - i][begin];
        // 下面转到左边
        for (int i = begin; i < begin + len; i++)
            matrix[i][begin] = matrix[matrix.length - 1 - index][i];
        // 右边转到下面
        for (int i = begin; i < begin + len; i++)
            matrix[matrix.length - 1 - index][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - index];
        // 上面转到右边
        for (int i = begin; i < begin + len; i++)
            matrix[i][matrix.length - 1 - index] = temp[i - begin];
    }
}