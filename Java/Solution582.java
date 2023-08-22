class Solution582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int n = pid.size();
        Map<Integer, Integer> pid_map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pid_map.put(pid.get(i), i);
        }
        pid_map.put(0, n);
        // 用邻接表表示图
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++){
            adjacencyList.get(pid_map.get(ppid.get(i))).add(i);
        }
        // BFS 遍历
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        List<Integer> res = new ArrayList<>();
        queue.offer(pid_map.get(kill));
        visited[pid_map.get(kill)] = true;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            res.add(pid.get(i));
            // 相邻结点入队
            for (int t : adjacencyList.get(i)) {
                if (!visited[t]) queue.offer(t);
                visited[t] = true;
            }
        }
        return res;
    }
}