class Solution1091 {
    private int[][] directions = new int[][] {
            new int[] {-1, -1},
            new int[] {0, -1},
            new int[] {1, -1},
            new int[] {-1, 0},
            new int[] {1, 0},
            new int[] {-1, 1},
            new int[] {0, 1},
            new int[] {1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Deque<Integer> queue = new ArrayDeque<>();
        int[][] dists = new int[n][n];
        // 初始化
        for (int[] dist : dists) {
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        // BFS
        if (grid[0][0] != 0) return -1;
        else {
            queue.offer(0);
            dists[0][0] = 1;
        }
        while (!queue.isEmpty()) {
            int point = queue.poll();
            int x = point / n, y = point % n;
            if (x == n - 1 && y == n - 1) return dists[x][y];
            // 判断 8 个方向是否都走过了
            for (int[] dir : directions) {
                if (isValid(x + dir[0], y + dir[1], grid) && dists[x + dir[0]][y + dir[1]] == Integer.MAX_VALUE) {
                    queue.offer((x + dir[0]) * n + y + dir[1]);
                    dists[x + dir[0]][y + dir[1]] = Math.min(dists[x][y] + 1, dists[x + dir[0]][y + dir[1]]);
                }
            }
        }
        return -1;
    }

    public boolean isValid(int x, int y, int[][] grid) {
        int n = grid.length;
        return 0 <= x && x < n && 0 <= y && y < n && grid[x][y] == 0;
    }
}