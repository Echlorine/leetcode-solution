class Solution317 {
    private int[][] dirs = new int[][] {
            new int[] {0, 1},
            new int[] {1, 0},
            new int[] {0, -1},
            new int[] {-1, 0}
    };
    
    private int res;

    public int shortestDistance(int[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) num++;
            }
        }
        this.res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    bfs(grid, i * grid[0].length + j, num);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void bfs(int[][] grid, int index, int num) {
        int m = grid.length, n = grid[0].length;
        int disSum = 0, visSum = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        int[][] dis = new int[m][n];
        queue.offer(index);
        dis[index / n][index % n] = 0;
        visited[index / n][index % n] = true;
        while (!queue.isEmpty()) {
            int t = queue.poll();
            int x = t / n, y = t % n;
            for (int[] dir : dirs) {
                int t_x = x + dir[0], t_y = y + dir[1];
                if (t_x >= 0 && t_x < m && t_y >= 0 && t_y < n && grid[t_x][t_y] != 2 && !visited[t_x][t_y]) {
                    dis[t_x][t_y] = dis[x][y] + 1;
                    visited[t_x][t_y] = true;
                    if (grid[t_x][t_y] == 1) {
                        disSum += dis[t_x][t_y];
                        if (disSum > this.res) return;
                        visSum++;
                        continue;
                    }
                    else queue.offer(t_x * n + t_y);
                }
            }
        }
        if (visSum == num) {
            this.res = Math.min(this.res, disSum);
        }
    }
}