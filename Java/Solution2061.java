class Solution2061 {
    private int[] actions;
    private int[][] directions;
    private int res;
    
    public int numberOfCleanRooms(int[][] room) {
        res = 0;
        actions = new int[] {0, 1, 2, 3};
        directions = new int[][]{
            new int[] {0, 1},
            new int[] {1, 0},
            new int[] {0, -1},
            new int[] {-1, 0},
        };
        int[][] visited = new int[room.length][room[0].length];
        dfs(room, visited, 0, 0, 0);
        return res;
    }

    public void dfs(int[][] room, int[][] visited, int x, int y, int action) {
        /**
         * 右移，下移，左移，上移
         *  0     1    2     3
         */
        visited[x][y]++;
        if (visited[x][y] == 1) res++;
        for (int i = 0; i < 4; i++) {
            int temp = (action + i) % 4;
            if (go(room, x, y, temp)) {
                dfs(room, visited, x + directions[temp][0], y + directions[temp][1], actions[temp]);
                break;
            }
            else {
                visited[x][y]++;
            }
            if (visited[x][y] >= 4) return;
        }
    }

    public boolean go(int[][] room, int x, int y, int action) {
        if (x + directions[action][0] >= 0 && x + directions[action][0] < room.length
            && y + directions[action][1] >= 0 && y + directions[action][1] < room[0].length
            && room[x + directions[action][0]][y + directions[action][1]] != 1
            )
        return true;
        return false;
    }
}