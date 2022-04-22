import java.util.*;

class Solution323 {
    public int countComponents(int n, int[][] edges) {
        // 用 邻接矩阵 表示无向图
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        // dfs
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited);
                res++;
            }
        }
        return res;
    }

    public void dfs(List<List<Integer>> adj, int index, boolean[] visited) {
        visited[index] = true; // 访问当前结点
        List<Integer> veradjs = adj.get(index);
        for (int veradj : veradjs)
            if (!visited[veradj])
                dfs(adj, veradj, visited);

    }
}