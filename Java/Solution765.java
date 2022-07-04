class Solution765 {
    private int[] parent;
    private int[] rank;
    private int num;
    // Map<Integer, Integer>map;

    /**
     * 把互相之间坐错位置的情侣当作一个连通分量
     * 这一组连通分量中需要交换的次数即为连通分量的成员数量 - 1
     * 通过累加也可以发现总共需要交换的次数为总情侣对数 n/2 - 连通分量的数量
     * @param row
     * @return int
     */
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        parent = new int[n / 2];
        rank = new int[n / 2];
        num = 0;
        // map = new HashMap<>();
        // 初始化并查集，一对情侣有一个代表
        for (int i = 0; i < n / 2; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < row.length; i = i + 2) {
            int first = row[i], second = row[i + 1];
            if (first / 2 != second / 2) {
                union(first, second);
            }
        }
        // 统计连通分量的成员数量 - 1
        // int res = 0;
        // for (Integer i : map.keySet()) {
        //     res += map.get(i) - 1;
        // }
        // return res;
        return num;
    }

    public int find(int xReally) {
        if (parent[xReally] != xReally) {
            parent[xReally] = find(parent[xReally]);
        }
        return parent[xReally];
    }

    public void union(int x, int y) {
        int xReally = x / 2, yReally = y / 2; // 第几对情侣
        int xRoot = find(xReally), yRoot = find(yReally);
        if (xRoot != yRoot) {
            num++;
            if (rank[xRoot] <= rank[yRoot]) {
                parent[xRoot] = yRoot;
            }
            else {
                parent[yRoot] = xRoot;
            }
            if (rank[xRoot] == rank[yRoot]) rank[yRoot]++;
        }
    }
}