import java.util.*;

class Solution37 {
    public void solveSudoku(char[][] board) {
        // 建立visited
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] sudokus = new int[9][9][9];
        List<int[]> rem = new ArrayList<>();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    // 记录所有需要填数字的位置
                    rem.add(new int[] {i, j});
                    continue;
                }
                int num = board[i][j] - '0';
                // 判断所在行
                if (rows[i][num - 1] == 0) rows[i][num - 1] = 1;
                // 判断所在列
                if (columns[j][num - 1] == 0) columns[j][num - 1] = 1;
                // 判断所在3 * 3 数独
                if (sudokus[i / 3][j / 3][num - 1] == 0) sudokus[i / 3][j / 3][num - 1] = 1;
            }
        // 深度优先遍历
        dfs(board, rows, columns, sudokus, rem, 0, new boolean[] {false});
    }

    public void dfs(char[][] board, int[][] rows, int[][] columns, int[][][] sudokus, List<int[]> rem, int k, boolean[] flag) {
        if (k == rem.size()) {flag[0] = true; return;}
        int n = 1;
        int i = rem.get(k)[0], j = rem.get(k)[1];
        for (n = 1; n <= 9; n++) {
            if (rows[i][n - 1] == 1 || columns[j][n - 1] == 1 || sudokus[i / 3][j / 3][n - 1] == 1)
                continue;
            board[i][j] = (char) (n + 48); // 访问当前结点
            rows[i][n - 1] = 1;
            columns[j][n - 1] = 1;
            sudokus[i / 3][j / 3][n - 1] = 1;
            dfs(board, rows, columns, sudokus, rem, k + 1, flag);
            if (flag[0]) return;
            // 回溯
            board[i][j] = '.';
            rows[i][n - 1] = 0;
            columns[j][n - 1] = 0;
            sudokus[i / 3][j / 3][n - 1] = 0;
        }
        if (board[i][j] == '.') return;
    }
}