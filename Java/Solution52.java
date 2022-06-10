class Solution52 {
    public int totalNQueens(int n) {
        // visited
        boolean[][] visited = new boolean[n][n];
        return dfs(visited, 0, n);
    }

    public int dfs(boolean[][] visited, int index, int n) {
        if (index == n) return 1;
        int res= 0;
        for (int i = 0; i < n; i++) {
            // 判断当前节点是否可以访问
            int diff = i - index;
            int sum = i + index;
            boolean flag = true;
            for (int m = 0; m < n; m++) {
                if (!flag) break;
                if (visited[m][i]) // 判断同列
                    flag = false;
                if (m + diff >= 0 && m + diff < n && visited[m][m + diff]) //主对角线
                    flag = false;
                if (sum - m >= 0 && sum - m < n && visited[m][sum - m])
                    flag = false;
            }
            if (flag) {
                visited[index][i] = true;
                res += dfs(visited, index + 1, n);
                // 回溯
                for (int m = 0; m < n; m++) {
                    visited[m][i] = false; // 同列
                    if (m + diff >= 0 && m + diff < n) // 主对角线
                        visited[m][m + diff] = false;
                    if (sum - m >= 0 && sum - m < n) // 副对角线
                    visited[m][sum - m] = false;
                }
            }
        }
        return res;
    }
}