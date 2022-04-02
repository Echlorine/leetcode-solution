import java.util.*;

class Solution39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(res, ans, candidates, target, 0);
        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> ans, int[] candidates, int target, int index){
        if (target == 0) {res.add(new ArrayList<Integer>(ans)); return;}
        if (index == candidates.length) return;
        dfs(res, ans, candidates, target, index + 1);
        if (target - candidates[index] >= 0){
            ans.add(candidates[index]);
            dfs(res, ans, candidates, target - candidates[index], index);
            ans.remove(ans.size() - 1);
        }
    }
}