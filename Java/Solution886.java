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

class Solution886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        DisjointSet set = new DisjointSet(n);
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; ++i) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < dislikes.length; i++) {
            int a = dislikes[i][0] - 1, b = dislikes[i][1] - 1;
            // 确定分组
            list[a].add(b);
            list[b].add(a);
        }
        // 连接判断
        for (int i = 0; i < n; i++) {
            if (list[i].size() > 0) {
                int t = list[i].get(0);
                if (set.find(i) == set.find(t)) return false;
                for (int j = 1; j < list[i].size(); j++) {
                    set.union(t, list[i].get(j));
                    if (set.find(i) == set.find(list[i].get(j))) return false;
                }
            }
        }
        return true;
    }
}

class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot != yRoot) {
            if (rank[xRoot] <= yRoot) parent[xRoot] = yRoot;
            else parent[yRoot] = xRoot;
            if (rank[xRoot] == rank[yRoot]) rank[yRoot]++;
        }
    }
}