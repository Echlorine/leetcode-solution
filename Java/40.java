import java.util.*;

class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        dfs(candidates, res, ans, visited, target, 0);
        return res;
    }

    public void dfs(int[] candidates, List<List<Integer>> res, List<Integer> ans, boolean[] visited, int target, int index) {
        if (target == 0) {res.add(new ArrayList<Integer>(ans)); return;}
        if (index == candidates.length) return;
        for (int i = index; i < candidates.length; i++) {
            if (visited[i] || (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1])) continue;
            if (!visited[i] && target - candidates[i] >= 0) {
                visited[i] = true;
                ans.add(candidates[i]);
                dfs(candidates, res, ans, visited, target - candidates[i], i + 1);
                visited[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }
}