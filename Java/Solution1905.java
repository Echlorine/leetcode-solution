import java.util.Map;
import java.util.HashMap;

class Solution1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length, n = grid2[0].length;
        int num = 0;
        DisjointSet disjointSet = new DisjointSet(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    num++;
                    int index = i * n + j;
                    // 右
                    if (j + 1 < n && grid2[i][j + 1] == 1) {
                        disjointSet.union(index, index + 1);
                    }
                    // 下
                    if (i + 1 < m && grid2[i + 1][j] == 1) {
                        disjointSet.union(index, index + n);
                    }
                }
            }
        }
        int[] flags = new int[num - disjointSet.getNum()];
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    int a = disjointSet.find(i * n + j);
                    if (!map.containsKey(a)) {
                        map.put(a, index);
                        index++;
                    }
                    if (grid1[i][j] == 0) {
                        flags[map.get(a)] = 1;
                    }
                }
            }
        }
        int res = 0;
        for (int i : flags) {
            if (i == 1) {
                res++;
            }
        }
        return flags.length - res;
    }

    class DisjointSet {
        private int[] parent;
        private int[] rank;
        private int num;
    
        public DisjointSet(int m, int n) {
            this.parent = new int[m * n];
            this.rank = new int[m * n];
            num = 0;
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                rank[i] = 1;
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
                num++;
                if (rank[xRoot] <= rank[yRoot]) {
                    parent[xRoot] = yRoot;
                } else {
                    parent[yRoot] = xRoot;
                }
                if (rank[xRoot] == rank[yRoot]) {
                    rank[yRoot]++;
                }
            }
        }
    
        public int getNum() {
            return this.num;
        }
    }
}