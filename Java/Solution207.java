class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 邻接表表示图
        int[] inValues = new int[numCourses];
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
        int flag = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inValues[i] == 0) {
                queue.offer(i);
                flag++;
            }
        }
        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (int adj : adjacencyList.get(t)) {
                if (--inValues[adj] == 0) {
                    flag++;
                    queue.offer(adj);
                }
            }
        }
        return flag == numCourses;
    }
}