import java.util.*;

class Solution1136 {
    public int minimumSemesters(int n, int[][] relations) {
        int[] invalues = new int[n + 1];
        int[] outvalues = new int[n + 1];
        int[] res = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<Integer>());
        // 统计入度和出度，用邻接表表示有向图
        for (int i = 0; i < relations.length; i++) {
            invalues[relations[i][1]]++;
            outvalues[relations[i][0]]++;
            graph.get(relations[i][0]).add(relations[i][1]);
        }
        // 拓扑排序
        Deque<Integer> queue = new ArrayDeque<>();
        int adj = 0; // 记录拓扑排序的最后一个结点
        for (int i = 1; i <= n; i++)
            if (invalues[i] == 0)
                {queue.offer(i); res[i] = 1;}
        for (int i = 1; i <= n; i++) {
            if (queue.isEmpty()) return -1;
            adj = queue.poll();
            for (int j = 0; j < graph.get(adj).size(); j++) {
                int veradj = graph.get(adj).get(j);
                res[veradj] = Math.max(res[veradj], 1 + res[adj]);
                if (--invalues[veradj] == 0)
                    queue.offer(veradj);
            }
        }
        return res[adj];
    }
}