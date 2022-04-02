import java.util.*;

class Solution78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(res, ans, nums, 0);
        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> ans,int[] nums, int index){
        if (index == nums.length) {res.add(new ArrayList<Integer>(ans)); return;}
        // 添加当前值
        ans.add(nums[index]);
        dfs(res, ans, nums, index + 1);
        // 跳过当前值
        ans.remove(ans.size() - 1);
        dfs(res, ans, nums, index + 1);
    }
}