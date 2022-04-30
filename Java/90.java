import java.util.*;

class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] choice = new boolean[nums.length];
        dfs(res, ans, choice, nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> ans, boolean[] choice, int[] nums, int index) {
        if (index == nums.length) {res.add(new ArrayList<>(ans)); return;}
        // 剪枝条件，如果相邻的值相同，但是没选前面的，那么也不能选择后面的
        if (index > 0 && nums[index] == nums[index - 1] && !choice[index - 1]) {
            dfs(res, ans, choice, nums, index + 1);
            return;
        }
        // 添加当前值
        choice[index] = true;
        ans.add(nums[index]);
        dfs(res, ans, choice, nums, index + 1);
        // 不添加当前值
        choice[index] = false;
        ans.remove(ans.size() - 1);
        dfs(res, ans, choice, nums, index + 1);
    }
}