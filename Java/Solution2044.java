import java.util.ArrayList;
import java.util.List;

class Solution2044 {
    private List<Integer> list;

    public int countMaxOrSubsets(int[] nums) {
        list = new ArrayList<>();
        dfs(nums, 0, 0);
        int maxRes = 0, res = 0;
        for (int i = 0; i < list.size(); i++) {
            maxRes = Math.max(maxRes, list.get(i));
        }
        for (int result : list) {
            if (result == maxRes) {
                res++;
            }
        }
        return res;
    }

    public void dfs(int[] nums, int index, int ans) {
        if (index == nums.length) {
            list.add(ans);
            return;
        }
        // 不选择当前值
        dfs(nums, index + 1, ans);
        // 选择当前值
        dfs(nums, index + 1, ans | nums[index]);
    }
}