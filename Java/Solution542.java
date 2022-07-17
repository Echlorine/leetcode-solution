import java.util.*;

class Solution542 {
    public int[][] updateMatrix(int[][] mat) {
        Deque<int[]> queue = new ArrayDeque<>();
        int m = mat.length, n = mat[0].length;
        int[][] visited = new int[m][n];
        // 初始化
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = 0;
                }
                else visited[i][j] = -1;
            }
        }
        // BFS
        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            int temp = visited[index[0]][index[1]];
            // 右
            if (index[1] + 1 < n && visited[index[0]][index[1] + 1] == -1) {
                visited[index[0]][index[1] + 1] = temp + 1;
                queue.offer(new int[] {index[0], index[1] + 1});
            }
            // 下
            if (index[0] + 1 < m && visited[index[0] + 1][index[1]] == -1) {
                visited[index[0] + 1][index[1]] = temp + 1;
                queue.offer(new int[] {index[0] + 1, index[1]});
            }
            // 左
            if (index[1] - 1 >= 0 && visited[index[0]][index[1] - 1] == -1) {
                visited[index[0]][index[1] - 1] = temp + 1;
                queue.offer(new int[] {index[0], index[1] - 1});
            }
            // 上
            if (index[0] - 1 >= 0 && visited[index[0] - 1][index[1]] == -1) {
                visited[index[0] - 1][index[1]] = temp + 1;
                queue.offer(new int[] {index[0] - 1, index[1]});
            }
        }
        return visited;
    }
}