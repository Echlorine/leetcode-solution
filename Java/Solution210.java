class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inValues = new int[numCourses];
        // 邻接表表示图
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adjacencyList.get(p[0]).add(p[1]);
            inValues[p[1]]++;
        }
        // 拓扑排序
        Queue<Integer> queue = new ArrayDeque<>();
        int[] res = new int[numCourses];
        int flag = 0;
        for (int i = 0; i < numCourses; i++) {
            if(inValues[i] == 0) {
                queue.offer(i);
                res[numCourses - flag++ - 1] = i;
            }
        }
        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (int adj : adjacencyList.get(t)) {
                if(--inValues[adj] == 0) {
                    queue.offer(adj);
                    res[numCourses - flag++ - 1] = adj;
                }
            }
        }
        if (flag != numCourses) return new int[0];
        return res;
    }
}