class Solution79 {
    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean[] flag = new boolean[1];
        flag[0] = false;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == word.charAt(0)){
                    revisit(board, visited);
                    visited[i][j] = true;
                    find(board, word, visited,  i, j, 1, flag);
                    if (flag[0]) return flag[0];
            }
        return false;
    }

    // 初始化
    public static void revisit(char[][] board, boolean[][] visited){
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                visited[i][j] = false;
    }

    // 该函数用来判断一个字符的周边是否有我们需要的字符
    public static void find(char[][] board, String word, boolean[][] visited, int m, int n, int index, boolean[] flag){
        // 终止条件
        if (index == word.length()) {flag[0] = true; return;}
        // 下移
        if (m + 1 < board.length && !visited[m + 1][n] && board[m + 1][n] == word.charAt(index)){
            visited[m + 1][n] = true;
            find(board, word, visited, m + 1, n, index + 1, flag);
            if (flag[0]) return;
            visited[m + 1][n] = false; // 回溯
        }
        // 上移
        if (m - 1 >= 0 && !visited[m - 1][n] && board[m - 1][n] == word.charAt(index)){
            visited[m - 1][n] = true;
            find(board, word, visited, m - 1, n, index + 1, flag);
            if (flag[0]) return;
            visited[m - 1][n] = false; // 回溯
        }
        // 右移
        if (n + 1 < board[0].length && !visited[m][n + 1] && board[m][n + 1] == word.charAt(index)){
            visited[m][n + 1] = true;
            find(board, word, visited, m, n + 1, index + 1, flag);
            if (flag[0]) return;
            visited[m][n + 1] = false; // 回溯
        }
        // 左移
        if (n - 1 >= 0 && !visited[m][n - 1] && board[m][n - 1] == word.charAt(index)){
            visited[m][n - 1] = true;
            find(board, word, visited, m, n - 1, index + 1, flag);
            if (flag[0]) return;
            visited[m][n - 1] = false; // 回溯
        }
    }
}