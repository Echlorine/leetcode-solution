class Solution1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // 邻接表表示图
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] inVlaues = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adjacencyList.get(p[0]).add(p[1]);
            inVlaues[p[1]]++;
        }
        // 拓扑排序
        boolean[][] flags = new boolean[numCourses][numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inVlaues[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()) {
            int t = queue.poll();
            for (int adj : adjacencyList.get(t)) {
                flags[t][adj] = true;
                // 同时更新所有指向t的结点，也可以指向adj
                for (int i = 0; i < numCourses; i++) {
                    if (flags[i][adj]) continue;
                    flags[i][adj] = flags[i][t] && flags[t][adj];
                }
                if (--inVlaues[adj] == 0) {
                    queue.offer(adj);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(flags[q[0]][q[1]]);
        }
        return res;
    }
}