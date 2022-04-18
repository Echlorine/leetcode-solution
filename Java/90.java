import java.util.*;

class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, ans, nums, false, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> ans, int[] nums, boolean visited, int index) {
        if (index == nums.length) {res.add(new ArrayList<Integer>(ans)); return;}
        // 不添加当前值
        dfs(res, ans, nums, false, index + 1);
        // 添加当前值
        if (!visited && index > 0 && nums[index] == nums[index - 1])
            return;
        ans.add(nums[index]);
        dfs(res, ans, nums, true, index + 1);
        ans.remove(ans.size() - 1);
    }
}