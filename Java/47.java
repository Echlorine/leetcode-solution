import java.util.*;

class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 思路: dfs
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, res, ans, visited);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> ans, boolean[] visited) {
        if (ans.size() == nums.length) {res.add(new ArrayList<Integer>(ans)); return;}
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]))
                continue;
            ans.add(nums[i]);
            visited[i] = true;
            dfs(nums, res, ans, visited);
            ans.remove(ans.size() - 1);
            visited[i - 1] = false;
        }
    }
}