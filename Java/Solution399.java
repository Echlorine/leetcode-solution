import java.util.*;

class Solution399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 转化题目，方便用数组标识
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        for (List<String> equation : equations) {
            String str1 = equation.get(0), str2 = equation.get(1);
            if (!map.containsKey(str1)) {
                map.put(str1, index);
                index++;
            }
            if (!map.containsKey(str2)) {
                map.put(str2, index);
                index++;
            }
        }
        int len = equations.size();
        DisjointSet disjointSet = new DisjointSet(len * 2); // 初始化并查集
        // 根据题目进行并查集的合并及路径上的权值更新
        for (int i = 0; i < equations.size(); i++) {
            int x = map.get(equations.get(i).get(0)), y = map.get(equations.get(i).get(1));
            disjointSet.union(x, y, values[i]);
        }
        // 得到结果
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String str1 = queries.get(i).get(0), str2 = queries.get(i).get(1);
            if (!map.containsKey(str1) || !map.containsKey(str2)) {
                res[i] = -1.0d;
            }
            else {
                res[i] = disjointSet.getWeight(map.get(str1), map.get(str2));
            }
        }
        return res;

    }

    class DisjointSet {
        // 初始化并查集
        private int[] parent;
        private int[] rank; // 按秩合并，根据实际情况确定是按大小合并还是按秩合并
        private double[] weight; // 当前结点到并查集中代表结点的权值，带权并查集中使用

        public DisjointSet(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            weight = new double[n];
            
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
                weight[i] = 1.0d;
            }
        }

        /**
         * 带权并查集中带路径压缩的查找
         * @param x
         * @return
         */
        public int find(int x) {
            if (parent[x] != x) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        /**
         * 带权并查集的合并操作
         * @param x
         * @param y
         * @param value, x --> y 之间的权值
         */
        public void union(int x, int y, double value) {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot != yRoot) {
                if (rank[xRoot] <= rank[yRoot]) {
                    parent[xRoot] = yRoot;
                    weight[xRoot] = weight[y] * value / weight[x];
                }
                else {
                    parent[yRoot] = xRoot;
                    weight[yRoot] = weight[x] / (value * weight[y]);
                }
                if (rank[xRoot] == rank[yRoot]) rank[yRoot]++;
            }
        }

        /**
         * 得到并查集中 x --> y 之间的权值
         * @param x
         * @param y
         * @return
         */
        public double getWeight(int x, int y) {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot != yRoot) {
                return -1.0d;
            }
            return weight[x] / weight[y];
        }
    }
}