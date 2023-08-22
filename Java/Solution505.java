class Solution505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        // Dijkstra 算法
        PriorityQueue<int[]> values = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[][] dis = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == start[0] && j == start[1]) {
                    dis[i][j] = 0;
                    values.add(new int[]{i * n + j, dis[i][j]});
                }
                else {
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!values.isEmpty()) {
            int[] temp = values.poll();
            int x = temp[0] / n, y = temp[0] % n;
            if (dis[x][y] < temp[1]) continue; // 全部访问完成才会出现这种情况
            visited[x][y] = true;
            int t = 0, v = 0;
            // 右
            t = y;
            v = 0;
            while (t + 1 < n && maze[x][t + 1] == 0) {
                t++;
                v++;
            }
            if (!visited[x][t] && temp[1] + v < dis[x][t]) {
                // 更新当前结点的权值
                dis[x][t] = temp[1] + v;
                values.add(new int[] {x * n + t, dis[x][t]});
            }
            // 下
            t = x;
            v = 0;
            while (t + 1 < m && maze[t + 1][y] == 0) {
                t++;
                v++;
            }
            if (!visited[t][y] && temp[1] + v < dis[t][y]) {
                // 更新当前结点的权值
                dis[t][y] = temp[1] + v;
                values.add(new int[] {t * n + y, dis[t][y]});
            }
            // 左
            t = y;
            v = 0;
            while (t - 1 >= 0 && maze[x][t - 1] == 0) {
                t--;
                v++;
            }
            if (!visited[x][t] && temp[1] + v < dis[x][t]) {
                // 更新当前结点的权值
                dis[x][t] = temp[1] + v;
                values.add(new int[] {x * n + t, dis[x][t]});
            }
            // 上
            t = x;
            v = 0;
            while (t - 1 >= 0 && maze[t - 1][y] == 0) {
                t--;
                v++;
            }
            if (!visited[t][y] && temp[1] + v < dis[t][y]) {
                // 更新当前结点的权值
                dis[t][y] = temp[1] + v;
                values.add(new int[] {t * n + y, dis[t][y]});
            }
        }
        return dis[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dis[destination[0]][destination[1]];
    }
}


class Solution {
    private int res = -1;
    private int m, n;

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        int[][] dis = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i][j] == 1) visited[i][j] = true;
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        dis[start[0]][start[1]] = 0;
        dfs(maze, visited, dis, start[0] * n + start[1],destination[0] * n + destination[1], 0);
        return res;
    }

    public void dfs(int[][] maze, boolean[][] visited, int[][] dis, int loc, int destination, int len) {
        // 递归出口
        if (loc == destination) {
            if (res < 0) res = len;
            else res = Math.min(res, len);
            return;
        }
        int x = loc / n, y = loc % n;
        // 剪枝
        if (dis[x][y] < len) {
            return;
        }
        int t = 0, cnt = 0;
        // 右
        t = y;
        cnt = 0;
        while (t + 1 < n && maze[x][t + 1] == 0) {
            t++;
            cnt++;
        }
        if (!visited[x][t]) {
            visited[x][t] = true;
            dis[x][t] = Math.min(dis[x][t], len + cnt);
            dfs(maze, visited, dis, x * n + t, destination, len + cnt);
            visited[x][t] = false;
        }
        // 下
        t = x;
        cnt = 0;
        while (t + 1 < m && maze[t + 1][y] == 0) {
            t++;
            cnt++;
        }
        if (!visited[t][y]) {
            visited[t][y] = true;
            dis[t][y] = Math.min(dis[t][y], len + cnt);
            dfs(maze, visited, dis, t * n + y, destination, len + cnt);
            visited[t][y] = false;
        }
        // 左
        t = y;
        cnt = 0;
        while (t - 1 >= 0 && maze[x][t - 1] == 0) {
            t--;
            cnt++;
        }
        if (!visited[x][t]) {
            visited[x][t] = true;
            dis[x][t] = Math.min(dis[x][t], len + cnt);
            dfs(maze, visited, dis, x * n + t, destination, len + cnt);
            visited[x][t] = false;
        }
        // 上
        t = x;
        cnt = 0;
        while (t - 1 >= 0 && maze[t - 1][y] == 0) {
            t--;
            cnt++;
        }
        if (!visited[t][y]) {
            visited[t][y] = true;
            dis[t][y] = Math.min(dis[t][y], len + cnt);
            dfs(maze, visited, dis,t * n + y, destination, len + cnt);
            visited[t][y] = false;
        }
    }
}