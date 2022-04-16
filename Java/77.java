import java.util.*;

class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        dfs(res, ans, visited, n, 0, k);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> ans, boolean[] visited, int n, int index, int k) {
        if (ans.size() == k) {res.add(new ArrayList<Integer>(ans)); return;}
        for (int j = index; j < n; j++) {
            if (!visited[j]) {
                ans.add(j + 1);
                visited[j] = true;
                dfs(res, ans, visited, n, j + 1, k);
                // 回溯
                ans.remove(ans.size() - 1);
                visited[j] = false;
            }
        }
    }
}