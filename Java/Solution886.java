import java.util.*;

class Solution886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 用邻接表表示图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < dislikes.length; i++) {
            graph.get(dislikes[i][0]).add(dislikes[i][1]);
            graph.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        boolean[] visited = new boolean[n + 1];
        int[] colors = new int[n + 1];
        boolean res = true;
        for (int i = 1; i <= n; i++)
            res = res && dfs(graph, visited, colors, i, colors[i]);
        return res;
    }

    public boolean dfs(List<List<Integer>> graph, boolean[] visited, int[] colors, int index, int color) {
        visited[index] = true;
        colors[index] = color;
        List<Integer> veradjs = graph.get(index);
        for (int i = 0; i < veradjs.size(); i++) {
            if (!visited[veradjs.get(i)])
                dfs(graph, visited, colors, veradjs.get(i), 1 - color);
            if (visited[veradjs.get(i)] && colors[veradjs.get(i)] != 1 - color)
                return false;
        }
        return true;
    }
}