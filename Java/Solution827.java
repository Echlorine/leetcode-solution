class Solution827 {
    public int largestIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        DisjointSet disjointSet = new DisjointSet(n, m);
        // 并查集合并
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int index = i * m + j;
                    // 右
                    if (j + 1 < m && grid[i][j + 1] == 1) {
                        disjointSet.union(index, index + 1);
                    }
                    // 下
                    if (i + 1 < n && grid[i + 1][j] == 1) {
                        disjointSet.union(index, index + m);
                    }
                }
            }
        }
        int[][] pp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int index = i * m + j;
                pp[i][j] = disjointSet.find(index);
            }
        }
        // 计算结果
        int res = disjointSet.getMaxSize();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    int maxSize = disjointSet.getMaxSize();
                    int index = i * m + j;
                    int rP = 0, dP = 0, lP = 0, uP = 0;
                    int rS = 0, dS = 0, lS = 0, uS = 0;
                    // 右
                    if (j + 1 < m && grid[i][j + 1] == 1) {
                        rP = disjointSet.find(index + 1);
                        rS = disjointSet.getSize(rP);
                    }
                    // 下
                    if (i + 1 < n && grid[i + 1][j] == 1) {
                        dP = disjointSet.find(index + m);
                        dS = disjointSet.getSize(dP);
                    }
                    // 左
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        lP = disjointSet.find(index - 1);
                        lS = disjointSet.getSize(lP);
                    }
                    // 上
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        uP = disjointSet.find(index - m);
                        uS = disjointSet.getSize(uP);
                    }

                    // 右
                    if (j + 1 < m && grid[i][j + 1] == 1) {
                        disjointSet.union(index, index + 1);
                    }
                    // 下
                    if (i + 1 < n && grid[i + 1][j] == 1) {
                        disjointSet.union(index, index + m);
                    }
                    // 左
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        disjointSet.union(index, index - 1);
                    }
                    // 上
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        disjointSet.union(index, index - m);
                    }

                    // 右
                    if (j + 1 < m && grid[i][j + 1] == 1) {
                        disjointSet.setParent(rP, rP);
                        disjointSet.setSize(rP, rS);
                    }
                    // 下
                    if (i + 1 < n && grid[i + 1][j] == 1) {
                        disjointSet.setParent(dP, dP);
                        disjointSet.setSize(dP, dS);
                    }
                    // 左
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        disjointSet.setParent(lP, lP);
                        disjointSet.setSize(lP, lS);
                    }
                    // 上
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        disjointSet.setParent(uP, uP);
                        disjointSet.setSize(uP, uS);
                    }
                    disjointSet.setParent(index, index);
                    res = Math.max(res, disjointSet.getMaxSize());
                    disjointSet.setMaxSize(maxSize);
                }
            }
        }
        return res;
    }
}

class DisjointSet {
    private int[] parent;
    private int[] size;
    private int maxSize;

    public DisjointSet(int n, int m) {
        parent = new int[n * m];
        size = new int[n * m];
        maxSize = 1;
        for (int i = 0; i < n * m; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot != yRoot) {
            if (size[xRoot] <= size[yRoot]) {
                parent[xRoot] = yRoot;
                size[yRoot] += size[xRoot];
                maxSize = Math.max(size[yRoot], maxSize);
            } else {
                parent[yRoot] = xRoot;
                size[xRoot] += size[yRoot];
                maxSize = Math.max(size[xRoot], maxSize);
            }
        }
    }
    
    public int getMaxSize() {
        return this.maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getSize(int x) {
        return size[x];
    }

    public void setSize(int x, int xSize) {
        size[x] = xSize;
    }

    public void setParent(int x, int xRoot) {
        parent[x] = xRoot;
    }
}