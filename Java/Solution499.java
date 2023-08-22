class Solution499 {
    private int[][] dirs = new int[][] {
            new int[] {1, 0},  // 下 d
            new int[] {0, -1}, // 左 l
            new int[] {0, 1},  // 右 r
            new int[] {-1, 0}  // 上 u
    };

    private Map<Integer, Character> map = new HashMap<>(){{
        put(0, 'd');
        put(1, 'l');
        put(2, 'r');
        put(3, 'u');
    }};

    private int m, n;

    private int[] hole;
    private int d = Integer.MAX_VALUE;

    private String res;

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        m = maze.length;
        n = maze[0].length;
        this.hole = hole;
        int[][] dis = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        dis[ball[0]][ball[1]] = 0;
        visited[ball[0]][ball[1]] = true;
        dfs(maze, visited, dis, ball[0] * n + ball[1], 0, new StringBuilder());
        return d == Integer.MAX_VALUE ? "impossible" : res;
    }

    public void dfs(int[][] maze, boolean[][] visited, int[][] dis, int loc, int len, StringBuilder sb) {
        // 递归出口
        if (loc == hole[0] * n + hole[1]) {
            if (dis[hole[0]][hole[1]] < d) {
                d = dis[hole[0]][hole[1]];
                res = sb.toString();
            }
            return;
        }
        // 剪枝
        if (dis[loc / n][loc % n] < len) return;
        // DFS
        for (int i = 0; i < dirs.length; i++) {
            int x = loc / n, y = loc % n;
            int cnt = -1;
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                x += dirs[i][0];
                y += dirs[i][1];
                cnt++;
                if (x - dirs[i][0] == hole[0] && y - dirs[i][1] == hole[1]) break;
            }
            if (!visited[x - dirs[i][0]][y - dirs[i][1]]) {
                visited[x - dirs[i][0]][y - dirs[i][1]] = true;
                sb.append(map.get(i));
                dis[x - dirs[i][0]][y - dirs[i][1]] = Math.min(dis[x - dirs[i][0]][y - dirs[i][1]], len + cnt);
                dfs(maze, visited, dis, (x - dirs[i][0]) * n + y - dirs[i][1], len + cnt, sb);
                visited[x - dirs[i][0]][y - dirs[i][1]] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}


class Solution499 {
    private int[][] dirs = new int[][] {
            new int[] {1, 0},  // 下 d
            new int[] {0, -1}, // 左 l
            new int[] {0, 1},  // 右 r
            new int[] {-1, 0}  // 上 u
    };

    char[] map = new char[] {'d', 'l', 'r', 'u'};

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;
        int[][] dis = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        dis[ball[0]][ball[1]] = 0;
        // Dijkstra算法
        PriorityQueue<int[]> values = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        values.offer(new int[] {ball[0], ball[1], dis[ball[0]][ball[1]]});
        String[][] paths = new String[m][n]; // 记录路径
        paths[ball[0]][ball[1]] = "";
        while (!values.isEmpty()) {
            int[] point = values.poll();
            if (point[0] == hole[0] && point[1] == hole[1]) break;
            if (dis[point[0]][point[1]] < point[2]) continue; // 全部遍历完才会出现这种情况
            visited[point[0]][point[1]] = true;
            for (int i = 0; i < dirs.length; i++) { // 按照顺序将周围元素入队
                int x = point[0], y = point[1];
                int cnt = -1;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dirs[i][0];
                    y += dirs[i][1];
                    cnt++;
                    if (x - dirs[i][0] == hole[0] && y - dirs[i][1] == hole[1]) break;
                }
                x -= dirs[i][0];
                y -= dirs[i][1];
                if (visited[x][y]) continue;
                // 更新距离与路径
                if (dis[point[0]][point[1]] + cnt < dis[x][y]) {
                    dis[x][y] = dis[point[0]][point[1]] + cnt;
                    String str = paths[point[0]][point[1]] + map[i];
                    paths[x][y] = str;
                    
                } else if (dis[point[0]][point[1]] + cnt == dis[x][y]) {
                    // 距离相等时，按照字典序更新路径
                    String str = paths[point[0]][point[1]] + map[i];
                    paths[x][y] = paths[x][y].compareTo(str) < 0 ? paths[x][y] : str;
                }
                // 入队
                values.offer(new int[] {x, y, dis[x][y]});
            }
        }
        // 不能走进洞中
        if (dis[hole[0]][hole[1]] == Integer.MAX_VALUE) return "impossible";
        // 可以走进洞中，确定路径
        return paths[hole[0]][hole[1]];
    }
}