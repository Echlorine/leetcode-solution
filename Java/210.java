import java.util.*;

class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 以邻接表的形式表示有向图
        List<List<Integer>> graph = new ArrayList<>();
        int[] invalues = new int[numCourses]; // 统计每个结点的入度
        int[] outvalues = new int[numCourses]; // 统计每个结点的出度
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < prerequisites.length; i++) {
            invalues[prerequisites[i][0]]++;
            outvalues[prerequisites[i][1]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // 拓扑排序
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[numCourses];
        int index = 0;
        for (int i = 0; i < invalues.length; i++)
            if (invalues[i] == 0)
                {stack.addLast(i); res[index++] = i;}
        for (int i = 0; i < numCourses; i++) {
            if (stack.size() == 0) return new int[] {};
            int veradj = stack.removeLast();
            for (int j = 0; j < graph.get(veradj).size(); j++) {
                if (--invalues[graph.get(veradj).get(j)] == 0) {
                    stack.addLast(graph.get(veradj).get(j));
                    res[index++] = graph.get(veradj).get(j);
                }
            }
        }
        return res;
    }
}