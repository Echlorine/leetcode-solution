class Solution130 {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == 'O' && (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)) {
                    visited[i][j] = true;
                    dfs(visited, board, i ,j);
                }
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (!visited[i][j])
                    board[i][j] = 'X';
    }

    public void dfs(boolean[][] visited, char[][] board, int x, int y) {
        // 下移
        if (x + 1 < board.length && board[x + 1][y] == 'O' && !visited[x + 1][y]) {
            visited[x + 1][y] = true;
            dfs(visited, board, x + 1, y);
        }
        // 右移
        if (y + 1 < board[0].length && board[x][y+ 1] == 'O' && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            dfs(visited, board, x, y + 1);
        }
        // 上移
        if (x - 1 >= 0 && board[x - 1][y] == 'O' && !visited[x - 1][y]) {
            visited[x - 1][y] = true;
            dfs(visited, board, x - 1, y);
        }
        // 左移
        if (y - 1 >= 0 && board[x][y - 1] == 'O' && !visited[x][y - 1]) {
            visited[x][y - 1] = true;
            dfs(visited, board, x, y - 1);
        }
    }
}