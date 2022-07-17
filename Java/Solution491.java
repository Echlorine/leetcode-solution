import java.util.*;

class Solution491 {
    private List<List<Integer>> res;
    private Map<Integer, List<Integer>> map;

    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        map = new HashMap<>();
        // 通过哈希表记录某一个数字的所有下标
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        // 标记某一个结点是否访问
        boolean[] visited = new boolean[nums.length];
        dfs(nums, 0, 0, new ArrayList<Integer>(), visited);
        return res;
    }

    public void dfs(int[] nums, int index, int last, List<Integer> ans, boolean[] visited) {
        if (index == nums.length) return;
        int temp = last;
        for (int i = index; i < nums.length; i++) {
            boolean flag = false;
            for (int idx : map.get(nums[i])) {
                if (idx >= last && idx < i && !visited[idx]) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;
            int ans_len = ans.size();
            // 只允许比自己大的元素加入
            if (ans_len == 0 || (ans_len > 0 && nums[i] >= ans.get(ans_len - 1))) {
                temp = i; // 标记最后一个添加的位置
                ans.add(nums[i]);
                visited[i] = true;
                // 至少需要两个元素才能组成答案
                if (ans.size() >= 2) {
                    res.add(new ArrayList<Integer>(ans));
                }
                dfs(nums, i + 1, temp, ans, visited);
                // 回溯
                ans.remove(ans_len);
                visited[i] = false;
            }
        }
    }
}