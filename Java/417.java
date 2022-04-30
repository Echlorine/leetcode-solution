import java.util.*;

class Solution417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        boolean flag = true;
        for (int i = 0; i < heights.length; i++)
            for (int j = 0; j < heights[0].length; j++) {
                flag = true;
                visited = new boolean[heights.length][heights[0].length];
                flag = flag && atldfs(visited, heights, i, j);
                visited = new boolean[heights.length][heights[0].length];
                flag = flag && pacdfs(visited, heights, i, j);
                if (flag) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    res.add(ans);
                }
            }
        return res;
    }

    public boolean atldfs(boolean[][] visited, int[][] heights, int x, int y) {
        if (x == heights.length - 1 || y == heights[0].length - 1) return true;
        boolean atlflag = false;
        // 下移
        if (x + 1 < heights.length && heights[x + 1][y] <= heights[x][y] && !visited[x + 1][y]) {
            visited[x + 1][y] = true;
            atlflag = atlflag || atldfs(visited, heights, x + 1, y);
            if (atlflag) return atlflag;
        }
        // 右移
        if (y + 1 < heights[0].length && heights[x][y+ 1] <= heights[x][y] && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            atlflag = atlflag || atldfs(visited, heights, x, y + 1);
            if (atlflag) return atlflag;
        }
        // 上移
        if (x - 1 >= 0 && heights[x - 1][y] <= heights[x][y] && !visited[x - 1][y]) {
            visited[x - 1][y] = true;
            atlflag = atlflag || atldfs(visited, heights, x - 1, y);
            if (atlflag) return atlflag;
        }
        // 左移
        if (y - 1 >= 0 && heights[x][y - 1] <= heights[x][y] && !visited[x][y - 1]) {
            visited[x][y - 1] = true;
            atlflag = atlflag || atldfs(visited, heights, x, y - 1);
            if (atlflag) return atlflag;
        }
        return atlflag;
    }

    public boolean pacdfs(boolean[][] visited, int[][] heights, int x, int y) {
        if (x == 0 || y == 0) return true;
        boolean pacflag = false;
        // 下移
        if (x + 1 < heights.length && heights[x + 1][y] <= heights[x][y] && !visited[x + 1][y]) {
            visited[x + 1][y] = true;
            pacflag = pacflag || pacdfs(visited, heights, x + 1, y);
            if (pacflag) return pacflag;
        }
        // 右移
        if (y + 1 < heights[0].length && heights[x][y+ 1] <= heights[x][y] && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            pacflag = pacflag || pacdfs(visited, heights, x, y + 1);
            if (pacflag) return pacflag;
        }
        // 上移
        if (x - 1 >= 0 && heights[x - 1][y] <= heights[x][y] && !visited[x - 1][y]) {
            visited[x - 1][y] = true;
            pacflag = pacflag || pacdfs(visited, heights, x - 1, y);
            if (pacflag) return pacflag;
        }
        // 左移
        if (y - 1 >= 0 && heights[x][y - 1] <= heights[x][y] && !visited[x][y - 1]) {
            visited[x][y - 1] = true;
            pacflag = pacflag || pacdfs(visited, heights, x, y - 1);
            if (pacflag) return pacflag;
        }
        return pacflag;
    }
}