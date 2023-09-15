class Solution2849 {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int m = Math.abs(fy - sy), n = Math.abs(fx - sx);
        if (m == 0 && n == 0) return t != 1;
        int d = Math.min(m, n);
        d += Math.abs(m - n);
        return d <= t;
    }
}

// 转化为图的问题，但是把简单的问题复杂化了
class Solution2849BFS {
    // 8 个方向
    private int[][] dirs = new int[][] {
            new int[] {-1, -1},
            new int[] {-1, 0},
            new int[] {-1, 1},
            new int[] {0, -1},
            new int[] {0, 1},
            new int[] {1, -1},
            new int[] {1, 0},
            new int[] {1, 1}
    };

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        // 计算到达单元格的最快时间
        // 边界是start - finish 之间的区域
        // bfs
        int m = Math.abs(fy - sy) + 1, n = Math.abs(fx - sx) + 1;
        if (m == 1 && n == 1) return t != 1;
        int[][] dis = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] dir : dirs) {
                int x = p[0] + dir[0], y = p[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    dis[x][y] = dis[p[0]][p[1]] + 1;
                    visited[x][y] = true;
                    queue.offer(new int[] {x, y});
                }
            }
        }
        return dis[m - 1][n - 1] <= t;
    }
}