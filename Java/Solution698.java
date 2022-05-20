class Solution698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean[] visited = new boolean[nums.length];
        // 计算边长
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % k != 0) return false;
        sum /= k;
        int[] arrs = new int[k];
        return dfs(nums, visited, arrs, sum, 0);
    }

    public boolean dfs(int[] nums, boolean[] visited, int[] sums, int sum, int index) {
        boolean flag = true;
        for (int i = 0; i < sums.length; i++) {
            flag = flag && sums[i] == sum;
            if (!flag) break;
        }
        if (flag) return true;
        for (int loc = 0; loc < sums.length; loc++) {
            // 判断当前加在k组中的哪一组
            // 剪枝条件，添加元素在第一个不为0的边长或者不为0的边长
            if (loc > 0 && sums[loc] == 0 && sums[loc - 1] == 0)
                continue;
            if (sums[loc] + nums[index] <= sum) {
                visited[index] = true;
                sums[loc] += nums[index];
                if (dfs(nums, visited, sums, sum, index + 1)) return true;
                // 回溯
                visited[index] = false;
                sums[loc] -= nums[index];
            }
        }
        return false;
    }
}