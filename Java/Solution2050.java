class Solution2050 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            adjacencyList.add(new ArrayList<>());
        }
        int[] count = new int[n]; // 统计所有顶点的入度
        for (int[] relation : relations) {
            adjacencyList.get(relation[0] - 1).add(relation[1] - 1);
            count[relation[1] - 1]++;
        }
        // 拓扑排序
        Deque<Integer> stack = new ArrayDeque<>();
        int[] sort = new int[n]; // 拓扑序列
        int[] dp = new int[n];
        int res = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] == 0) {
                stack.push(i);
                sort[index++] = i;
                dp[i] = time[i];
                res = Math.max(res, dp[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            int j = stack.pop();
            for (int p : adjacencyList.get(j)) {
                count[p]--;
                if (count[p] == 0) {
                    stack.push(p);
                    sort[index++] = p;
                }
                dp[p] = Math.max(dp[p], dp[j] + time[p]);
                res = Math.max(res, dp[p]);
            }
        }
        return res;
    }
}