class Solution490 {
    private int[][] dirs = new int[][] {
        new int[] {0, 1},
        new int[] {1, 0},
        new int[] {0, -1},
        new int[] {-1, 0},
    };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(start[0] * n + start[1]);
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()) {
            int t = queue.poll();
            int x = t / n, y = t % n;
            if (x == destination[0] && y == destination[1]) return true;
            // 一直往四个方向走直到停下
            for (int[] dir : dirs) {
                int t_x = x + dir[0], t_y = y + dir[1];
                // 直到遇到墙壁才会停下
                while(t_x >= 0 && t_x < m && t_y >= 0 && t_y < n && maze[t_x][t_y] == 0) {
                    t_x += dir[0];
                    t_y += dir[1];
                }
                t_x -= dir[0];
                t_y -= dir[1];
                if (!visited[t_x][t_y]) {
                    queue.offer(t_x * n + t_y);
                    visited[t_x][t_y] = true;
                }
            }
        }
        return false;
    }
}