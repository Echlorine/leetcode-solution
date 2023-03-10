class Solution1210 {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        int[][][] dist = new int[n][n][2]; // 记录到(0,0)的最短距离
        bfs(grid, dist, n);
        return dist[n - 1][n - 2][0] - 1;
    }

    public void bfs(int[][] grid, int[][][] dist, int n) {
        // 用蛇尾作为判断标志，同时标识身体是水平还是竖直
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,0});
        dist[0][0][0] = 1; // 已经被水平状态的蛇访问过
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            if (loc[2] == 0) { // 身体水平
                // 右移
                if (loc[1] + 2 < n && grid[loc[0]][loc[1] + 2] == 0 && dist[loc[0]][loc[1] + 1][0] == 0) {
                    queue.offer(new int[]{loc[0], loc[1] + 1, 0});
                    dist[loc[0]][loc[1] + 1][0] = dist[loc[0]][loc[1]][0] + 1;
                }
                // 下移
                if (loc[0] + 1 < n && grid[loc[0] + 1][loc[1]] == 0 && grid[loc[0] + 1][loc[1] + 1] == 0 && dist[loc[0] + 1][loc[1]][0] == 0) {
                    queue.offer(new int[]{loc[0] + 1, loc[1], 0});
                    dist[loc[0] + 1][loc[1]][0] = dist[loc[0]][loc[1]][0] + 1;
                }
                // 顺时针，身体变为竖直
                if (loc[0] + 1 < n && grid[loc[0] + 1][loc[1]] == 0 && grid[loc[0] + 1][loc[1] + 1] == 0 && dist[loc[0]][loc[1]][1] == 0) {
                    queue.offer(new int[]{loc[0], loc[1], 1});
                    dist[loc[0]][loc[1]][1] = dist[loc[0]][loc[1]][0] + 1;
                }
            } else { // 身体竖直
                // 右移
                if (loc[1] + 1 < n && grid[loc[0]][loc[1] + 1] == 0 && grid[loc[0] + 1][loc[1] + 1] == 0 && dist[loc[0]][loc[1] + 1][1] == 0) {
                    queue.offer(new int[]{loc[0], loc[1] + 1, 1});
                    dist[loc[0]][loc[1] + 1][1] = dist[loc[0]][loc[1]][1] + 1;
                }
                // 下移
                if (loc[0] + 2 < n && grid[loc[0] + 2][loc[1]] == 0 && dist[loc[0] + 1][loc[1]][1] == 0) {
                    queue.offer(new int[]{loc[0] + 1, loc[1], 1});
                    dist[loc[0] + 1][loc[1]][1] = dist[loc[0]][loc[1]][1] + 1;
                }
                // 逆时针，身体变为水平
                if (loc[1] + 1 < n && grid[loc[0]][loc[1] + 1] == 0 && grid[loc[0] + 1][loc[1] + 1] == 0 && dist[loc[0]][loc[1]][0] == 0) {
                    queue.offer(new int[]{loc[0], loc[1], 0});
                    dist[loc[0]][loc[1]][0] = dist[loc[0]][loc[1]][1] + 1;
                }
            }
        }
        return;
    }
}