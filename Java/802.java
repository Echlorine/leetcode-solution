import java.util.*;

class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new LinkedList<>();
        // 此题中，图的表示是邻接表
        int[] invalue = new int[graph.length]; // 入度
        int[] outvalue = new int[graph.length]; // 出度
        // 创建反向图
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++)
            adj.add(new ArrayList<Integer>());
        // 统计反向图每个结点的出度和入度
        for (int i = 0; i < graph.length; i++) {
            invalue[i] = graph[i].length;
            for (int j = 0; j < invalue[i]; j++) {
                adj.get(graph[i][j]).add(i);
                outvalue[graph[i][j]]++;
            }
        }
        // 进行拓扑排序
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < invalue.length; i++)
            if (invalue[i] == 0)
                queue.offer(i);
        for (int i = 0; i < invalue.length; i++) {
            if (queue.size() == 0) break; // 有回路
            int loc = queue.poll();
            for (int j = 0; j < adj.get(loc).size(); j++)
                if (--invalue[adj.get(loc).get(j)] == 0)
                    queue.offer(adj.get(loc).get(j));
        }
        // 将更新后的入度为0的结点添加到结果
        for (int i = 0; i < invalue.length; i++)
            if (invalue[i] == 0) res.add(i);
        return res;
    }

    public List<Integer> dfseventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int[] visted = new int[graph.length];
        for (int i = 0; i < graph.length; i++)
            dfs(res, graph, visted, i);
        for (int i = 0; i < graph.length; i++)
            if (visted[i] == 2)
                res.add(i);
        return res;
    }

    public void dfs(List<Integer> res, int[][] graph, int[] visted, int index) {
        if (visted[index] == 1) return; // 当前结点已经被访问过
        visted[index] = 1; // 访问当前结点
        boolean flag = true; // 标记是否遇到环结点
        for (int i = 0; i < graph[index].length; i++) {
            if (visted[graph[index][i]] == 0) {
                dfs(res, graph, visted, graph[index][i]);
            }
            if (visted[graph[index][i]] == 1) {
                flag = false;
                dfs(res, graph, visted, graph[index][i]);
            }
        }
        if (flag) visted[index] = 2;
    }
}