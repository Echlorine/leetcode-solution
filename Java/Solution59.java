class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][]matrix = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        dfs(matrix, visited, 0, 0, 1, 1);
        return matrix;
    }

    public void dfs(int[][] matrix, boolean[][] visited, int x, int y, int action, int target) {
        /**
         * 先右移，再下移，再左移，再上移，依次循环，对应的action
         *    1      2       3      4
         */
        // 添加当前值
        visited[x][y] = true;
        matrix[x][y] = target;
        // 当前右移，可选操作优先为右移，其次下移
        if (action == 1) {
            if (y + 1 < matrix[0].length && !visited[x][y + 1])
                dfs(matrix, visited, x, y + 1, 1, ++target);
            if (x + 1 < matrix.length && !visited[x + 1][y])
                dfs(matrix, visited, x + 1, y, 2, ++target);
        }
        // 当前下移，可选操作优先为下移，其次左移
        else if (action == 2) {
            if (x + 1 < matrix.length && !visited[x + 1][y])
                dfs(matrix, visited, x + 1, y, 2, ++target);
            if (y - 1 >= 0 && !visited[x][y - 1])
                dfs(matrix, visited, x, y - 1, 3, ++target);
        }
        // 当前左移，可选操作优先为左移，其次上移
        else if (action == 3) {
            if (y - 1 >= 0 && !visited[x][y - 1])
                dfs(matrix, visited, x, y - 1, 3, ++target);
            if (x - 1 >= 0 && !visited[x - 1][y])
                dfs(matrix, visited, x - 1, y, 4, ++target);
        }
        // 当前上移，可选操作优先为上移，其次右移
        else {
            if (x - 1 >= 0 && !visited[x - 1][y])
                dfs(matrix, visited, x - 1, y, 4, ++target);
            if (y + 1 < matrix[0].length && !visited[x][y + 1])
                dfs(matrix, visited, x, y + 1, 1, ++target);
        }
    }
}