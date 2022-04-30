import java.util.*;

class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // 排序
        // dfs
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(res, ans, visited, nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> ans, boolean[] visited, int[] nums) {
        if (ans.size() == nums.length) {res.add(new LinkedList<Integer>(ans)); return;}
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue; // 剪枝
            if (!visited[i]) {
                visited[i] = true;
                ans.add(nums[i]);
                dfs(res, ans, visited, nums);
                visited[i] = false;
                ans.remove(ans.size() - 1); // 回溯
            }
        }
    }
}