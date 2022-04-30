import java.util.*;

class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        dfs(res, ans, visited, candidates, target, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> ans, boolean[] visited, int[] candidates, int target, int index) {
        if (target == 0) {res.add(new LinkedList<>(ans)); return;}
        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) // 剪枝
                continue;
            if (candidates[i] > target)
                continue;
            visited[i] = true;
            ans.add(candidates[i]);
            dfs(res, ans, visited, candidates, target - candidates[i], i + 1);
            visited[i] = false;
            ans.remove(ans.size() - 1);
        }
    }
}