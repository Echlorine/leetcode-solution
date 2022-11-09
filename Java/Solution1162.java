import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution1162 {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        // 用邻接表表示图
        List<List<Integer>> adjacentList = new ArrayList<>();
        for (int i = 0; i < n * n; i++) {
            adjacentList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                // 右
                if (j + 1 < n) {
                    adjacentList.get(index).add(index + 1);
                    adjacentList.get(index + 1).add(index);
                }
                // 下
                if (i + 1 < n) {
                    adjacentList.get(index).add(index + n);
                    adjacentList.get(index + n).add(index);
                }
            }
        }
        // BFS
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        // 陆地单元格入队
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int index = i * n + j;
                    queue.offer(index);
                    visited[i][j] = true;
                }
            }
        }
        if (queue.size() == 0 || queue.size() == n * n) return -1;
        // BFS 确定最短路径
        int res = 0;
        int[][] dist = new int[n][n];
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int i = index / n, j = index % n;
            for (int k : adjacentList.get(index)) {
                int p = k / n, q = k % n;
                if (!visited[p][q]) {
                    visited[p][q] = true;
                    dist[p][q] = dist[i][j] + 1;
                    queue.offer(k);
                    res = Math.max(res, dist[p][q]);
                }
            }
        }
        return res;
    }
}