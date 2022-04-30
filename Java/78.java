import java.util.*;

class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(res, ans, nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> ans, int[] nums, int index) {
        if (index == nums.length) {res.add(new ArrayList<>(ans)); return;}
        // 不添加当前结点
        dfs(res, ans, nums, index + 1);
        // 添加当前结点
        ans.add(nums[index]);
        dfs(res, ans, nums, index + 1);
        ans.remove(ans.size() - 1);
    }
}