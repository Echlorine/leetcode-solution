public class offer13 {
    private int res;

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        res = 0;
        if (border(0, 0, k)) {
            res++;
            dfs(visited, k, 0, 0);
        }
        return res;
    }

    public void dfs(boolean[][] visited, int ceil, int x, int y) {
        // 下移
        if (x + 1 < visited.length && !visited[x + 1][y] && border(x + 1, y, ceil)) {
            visited[x + 1][y] = true;
            res++;
            dfs(visited, ceil, x + 1, y);
        }
        // 右移
        if (y + 1 < visited[0].length && !visited[x][y + 1] && border(x, y + 1, ceil)) {
            visited[x][y + 1] = true;
            res++;
            dfs(visited, ceil, x, y + 1);
        }
        // 上移
        if (x - 1 >= 0 && !visited[x - 1][y] && border(x - 1, y, ceil)) {
            visited[x - 1][y] = true;
            res++;
            dfs(visited, ceil, x - 1, y);
        }
        // 左移
        if (y - 1 >= 0 && !visited[x][y - 1] && border(x, y - 1, ceil)) {
            visited[x][y - 1] = true;
            res++;
            dfs(visited, ceil, x, y - 1);
        }
    }

    public boolean border(int x, int y, int ceiling) {
        int res = 0;
        String s1 = String.valueOf(x);
        String s2 = String.valueOf(y);
        int len = Math.max(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (i < s1.length())
                res += s1.charAt(i) - '0';
            if (i < s2.length())
                res += s2.charAt(i) - '0';
        }
        return res <= ceiling;
    }
}