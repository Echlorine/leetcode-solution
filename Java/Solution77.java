import java.util.*;

class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        dfs(res, ans, 1, n, k);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> ans, int index, int n, int len) {
        if (ans.size() == len) {res.add(new LinkedList<Integer>(ans)); return;}
        for (int i = index; i <= n; i++) {
            ans.add(i);
            dfs(res, ans, i + 1, n, len);
            ans.remove(ans.size() - 1);
        }
    }
}