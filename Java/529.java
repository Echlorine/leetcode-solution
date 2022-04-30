class Solution529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        if (board[click[0]][click[1]] == 'M') {
            // 规则 1，点到雷改为X退出游戏
            board[click[0]][click[1]] = 'X';
        } else if (board[click[0]][click[1]] == 'E') {
            // 只有当点的是未被访问过的格子E才进入递归和判断
            dfs(visited, board, click[0], click[1]);
        }
        return board;
    }

    public void dfs(boolean[][] visited, char[][] board, int x, int y) {
        // 访问当前结点
        visited[x][y] = true;
        if (count(board, x, y) == 0) {
            board[x][y] = 'B';
            int[] diff = new int[] {-1, 0, 1};
            // 访问周围结点
            for (int i = 0; i < diff.length; i++)
                for (int j = 0; j < diff.length; j++) {
                    if (diff[i] == 0 && diff[j] == 0) continue;
                    if (x + diff[i] < 0 || x + diff[i] >= board.length || y + diff[j] < 0 || y + diff[j] >= board[0].length || visited[x + diff[i]][y + diff[j]]) continue;
                    dfs(visited, board, x + diff[i], y + diff[j]);
                }
        }
        else board[x][y] = (char) (count(board, x, y) + '0');
    }

    public int count(char[][] board, int x, int y) { // 确定周围雷的数量
        int res = 0;
        int[] diff = new int[] {-1, 0, 1};
        for (int i = 0; i < diff.length; i++)
            for (int j = 0; j < diff.length; j++) {
                if (diff[i] == 0 && diff[j] == 0) continue;
                if (x + diff[i] < 0 || x + diff[i] >= board.length || y + diff[j] < 0 || y + diff[j] >= board[0].length) continue;
                if (board[x + diff[i]][y + diff[j]] == 'M') res++;
            }
        return res;
    }
}

/**
* 点击的格子是M，直接改为X并退出游戏
* 点击的格子是是B或者数字，什么也不做退出游戏（题解里其实可以加上这个else if的判断）
* 点击的格子是E才扩展：计算当前格子周围的雷的数量cnt，决定当前格子从E改为B还是改为数字；若改为数字则终止扩展（这也是为什么示例1还剩一个E），若改为B则继续扩展（遇到E才扩展，遇到B或者数字则终止）
*/