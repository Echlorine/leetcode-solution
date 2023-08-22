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

class Solution {
    public int countComponents(int n, int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(n);
        for (int[] edge: edges) {
            disjointSet.union(edge[0], edge[1]);
        }
        return disjointSet.getNum();
    }
}

class DisjointSet {
    private int[] parent;

    private int[] rank;

    private int num;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        num = 0;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        // 查找，路径压缩
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        // 合并
        int p_x = find(x), p_y = find(y);
        if (p_x != p_y) {
            if (rank[p_x] <= rank[p_y]) parent[p_x] = p_y;
            else parent[p_y] = p_x;
            if(rank[p_x] == rank[p_y]) {
                // 更新树高
                rank[p_y]++;
            }
            num++;
        }
    }

    public int getNum() {
        return parent.length - num;
    }
}