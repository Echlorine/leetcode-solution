import java.util.*;

class Solution694 {
    private Set<List<Integer>> islands = new HashSet<>();

    public int numDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<Integer> path = new LinkedList<>();
                    dfs(grid, visited, i, j, new int[] {i, j}, path);
                    islands.add(path);
                }
            }
        }
        return islands.size();
    }

    public void dfs(int[][] grid, boolean[][] visited, int x, int y, int[] direction, List<Integer> path) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1 || visited[x][y]) return;
        visited[x][y] = true; // 标记当前结点已经访问
        path.add(x - direction[0]); // 记录访问路径
        path.add(y - direction[1]);
        dfs(grid, visited, x + 1, y, direction, path);
        dfs(grid, visited, x, y + 1, direction, path);
        dfs(grid, visited, x - 1, y, direction, path);
        dfs(grid, visited, x, y - 1, direction, path);
    }
}