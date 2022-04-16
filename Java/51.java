import java.util.*;

class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        // visited
        boolean[][] visited = new boolean[n][n];
        dfs(res, ans, visited, 0, n);
        return res;
    }

    public void dfs(List<List<String>> res, List<String> ans, boolean[][] visited, int index, int n) {
        if (index == n) {res.add(new ArrayList<>(ans)); return;}
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.delete(0, str.length());
            // 每一行有n个备选位置可以选择，当前选择第i个位置
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
                for (int s = 0; s < n; s++)
                    if (s == i) str.append("Q");
                    else str.append(".");
                ans.add(str.toString());
                visited[index][i] = true;
                dfs(res, ans, visited, index + 1, n);
                ans.remove(ans.size() - 1);
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
    }
}