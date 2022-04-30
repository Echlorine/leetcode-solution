import java.util.*;

class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        dfs(res, ans, candidates, target, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> ans, int[] candidates, int target, int index) {
        if (target == 0) {res.add(new LinkedList<Integer>(ans)); return;}
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) continue; // 剪枝
            ans.add(candidates[i]);
            dfs(res, ans, candidates, target - candidates[i], i);
            ans.remove(ans.size() - 1);
        }
    }
}