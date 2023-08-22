class Solution286 {
    private int[][] dirs = new int[][] {
            new int[] {0, 1},
            new int[] {1,0},
            new int[] {-1, 0},
            new int[] {0, -1}
    };
    
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(i * n + j);
                    visited[i][j] = true;
                } else if (rooms[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }
        // BFS
        while (!queue.isEmpty()) {
            int t = queue.poll();
            int x = t / n, y = t % n;
            for (int[] dir : dirs) {
                if (x + dir[0] < m && x + dir[0] >= 0 && y + dir[1] < n && y + dir[1] >= 0 && !visited[x + dir[0]][y + dir[1]]) {
                    visited[x + dir[0]][y + dir[1]] = true;
                    rooms[x + dir[0]][y + dir[1]] = rooms[x][y] + 1;
                    queue.offer((x + dir[0]) * n + y + dir[1]);
                }
            }
        }
    }
}