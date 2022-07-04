class Solution1319 {
    private int[] parent;
    private int[] rank;
    private int num;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        // 初始化并查集及其高度
        parent = new int[n];
        rank = new int[n];
        num = 0;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int[] connection : connections) {
            int x = connection[0], y = connection[1];
            union(x, y);
        }
        return n - num - 1; // 连通分量数量 - 1
    }

    // 查找
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // 合并
    public void union(int x, int y) {
        int xroot = find(x), yroot = find(y);
        if (xroot != yroot) {
            num++;
            if (rank[xroot] <= rank[yroot]) parent[xroot] = yroot;
            else parent[yroot] = xroot;
            if (rank[xroot] == rank[yroot]) rank[yroot]++;
        }
    }
}