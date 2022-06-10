class Solution785 {
    public boolean isBipartite(int[][] graph) {
        // 这道题图的表示也是邻接表
        boolean[] visited = new boolean[graph.length];
        int[] colors = new int[graph.length];
        boolean res = true;
        // 图不一定是连通图
        for (int i = 0; i < graph.length; i++)
            res = res && dfs(graph, visited, colors, i, colors[i]);
        return res;
    }

    public boolean dfs(int[][] graph, boolean[] visited, int[] colors, int index, int color) {
        visited[index] = true; // 标记当前结点已经访问
        colors[index] = color; // 给当前结点涂色
        for (int veradj : graph[index]) {
            if (!visited[veradj])
                dfs(graph, visited, colors, veradj, 1 - color);
            if (visited[veradj] && colors[veradj] != 1 - color)
                return false;
        }
        return true;
    }
}