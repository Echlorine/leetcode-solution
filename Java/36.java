class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] sudokus = new int[9][9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                // 判断所在行
                if (rows[i][num - 1] == 0) rows[i][num - 1] = 1;
                else return false;
                // 判断所在列
                if (columns[j][num - 1] == 0) columns[j][num - 1] = 1;
                else return false;
                // 判断所在3 * 3 数独
                if (sudokus[i / 3][j / 3][num - 1] == 0) sudokus[i / 3][j / 3][num - 1] = 1;
                else return false;
            }
        return true;
    }
}