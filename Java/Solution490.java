class Solution490 {
    private int m, n;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        return bfs(maze, start, destination);
    }

    public boolean bfs(int[][] maze, int[] start, int[] destination) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(start[0] * n + start[1]);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int point = queue.poll();
            int x = point / n, y = point % n;
            int t_x = x, t_y = y;
            // 一直向上
            while (x - 1 >= 0 && maze[x - 1][y] == 0) {
                x--;
            }
            if (!visited[x][y]) {
                queue.offer(x * n + y);
                visited[x][y] = true;
            }
            x = t_x;
            // 一直向下
            while (x + 1 < m && maze[x + 1][y] == 0) {
                x++;
            }
            if (!visited[x][y]) {
                queue.offer(x * n + y);
                visited[x][y] = true;
            }
            x = t_x;
            // 一直向左
            while (y - 1 >= 0 && maze[x][y - 1] == 0) {
                y--;
            }
            if (!visited[x][y]) {
                queue.offer(x * n + y);
                visited[x][y] = true;
            }
            y = t_y;
            // 一直向右
            while (y + 1 < n && maze[x][y + 1] == 0) {
                y++;
            }
            if (!visited[x][y]) {
                queue.offer(x * n + y);
                visited[x][y] = true;
            }
        }
        return visited[destination[0]][destination[1]];
    }
}