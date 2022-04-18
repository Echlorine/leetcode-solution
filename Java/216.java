import java.util.*;

class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(res, ans, n, 1, k);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> ans, int target, int index, int k) {
        if (target == 0 && ans.size() == k) {res.add(new ArrayList<Integer>(ans)); return;}
        if (ans.size() == k) return;
        for (int i = index; i <= 9; i++) {
            if (target < i) break; // 剪枝
            // 访问当前结点
            ans.add(i);
            dfs(res, ans, target - i, i + 1, k);
            ans.remove(ans.size() - 1);
        }
    }
}