class Solution2603 {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int res = coins.length;
        // 建图
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] values = new int[coins.length];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < coins.length; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
            values[edge[0]]++;
            values[edge[1]]++;
        }
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] == 0 && values[i] == 1) {
                values[i] = 0;
                queue.offer(i);
                res--;
            }
        }
        // 拓扑排序得到非空叶节点
        while(!queue.isEmpty()) {
            int t = queue.poll();
            for (int adj : adjacencyList.get(t)) {
                if(--values[adj] == 1 && coins[adj] == 0) {
                    values[adj] = 0;
                    queue.offer(adj);
                    res--;
                }
            }
        }
        // 第一次拓扑排序
        for (int i = 0; i < coins.length; i++) {
            if(values[i] == 1) {
                queue.offer(i);
                res--;
            }
        }
        // 第二次拓扑排序
        int len = queue.size();
        for (int j = 0; j < len; j++) {
            int t = queue.poll();
            for (int adj : adjacencyList.get(t)) {
                if(--values[adj] == 1) {
                    queue.offer(adj);
                    res--;
                }
            }
        }
        return res == 0 ? 0 : 2 * (res - 1);
    }
}