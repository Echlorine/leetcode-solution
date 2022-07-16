import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // 并查集确定字符串间的连通分量
        DisjointSet disjointSet = new DisjointSet(s.length());
        for (List<Integer> pair : pairs) {
            int x = pair.get(0).intValue(), y = pair.get(1).intValue();
            disjointSet.union(x, y);
        }
        char[] charArray = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            int index= disjointSet.find(i);
            if (map.containsKey(index)) {
                map.get(index).add(charArray[i]);
            }
            else {
                PriorityQueue<Character> val = new PriorityQueue<>();
                val.add(charArray[i]);
                map.put(index, val);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            int index= disjointSet.find(i);
            sb.append(map.get(disjointSet.find(index)).poll());
        }
        return sb.toString();
    }

    class DisjointSet {
        private int[] parent;
        private int[] rank;

        public DisjointSet(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
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
                if (rank[xRoot] <= rank[yRoot]) {
                    parent[xRoot] = yRoot;
                }
                else {
                    parent[yRoot] = xRoot;
                }
                if (rank[xRoot] == rank[yRoot]) rank[yRoot] += 1;
            }
        }

        public int getrank(int x) {
            return rank[parent[x]];
        }
    }
}