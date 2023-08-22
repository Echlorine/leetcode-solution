import java.util.*;

class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] inValues = new int[n]; // 入度
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        // 构建反向图
        for (int i = 0; i < n; i++) {
            for (int g : graph[i]) {
                adjacencyList.get(g).add(i);
                inValues[i]++;
            }
        }
        // 反向拓扑排序
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inValues[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (int adj : adjacencyList.get(t)) {
                inValues[adj]--;
                if (inValues[adj] == 0) queue.offer(adj);
            }
        }
        // 得到结果
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inValues[i] == 0) res.add(i);
        }
        return res;
    }
}

class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int[] visted = new int[graph.length];
        for (int i = 0; i < graph.length; i++)
            dfs(graph, visted, i);
        for (int i = 0; i < graph.length; i++)
            if (visted[i] == 2)
                res.add(i);
        return res;
    }

    public void dfs(int[][] graph, int[] visted, int index) {
        if (visted[index] == 1) return; // 当前结点已经被访问过
        visted[index] = 1; // 访问当前结点
        boolean flag = true; // 标记是否遇到环结点
        for (int i = 0; i < graph[index].length; i++) {
            if (visted[graph[index][i]] == 0) {
                dfs(graph, visted, graph[index][i]);
            }
            if (visted[graph[index][i]] == 1) {
                flag = false;
                break;
            }
        }
        if (flag) visted[index] = 2;
    }
}