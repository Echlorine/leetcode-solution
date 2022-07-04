class Solution990 {
    private char[] parent = new char[26];
    private int[] rank = new int[26];

    public boolean equationsPossible(String[] equations) {
        // 初始化并查集及其高度
        for (int i = 0; i < 26; i++) {
            char index = (char) ('a' + i);
            parent[i] = index;
            rank[i] = 1;
        }
        // 遍历数组，确定连通分量的数量
        for (int i = 0; i < equations.length; i++) {
            String temp = equations[i];
            char x = temp.charAt(0), y = temp.charAt(3);
            if (temp.charAt(1) == '=') {
                // 这两个字母连通
                union(x, y);
            }
        }
        for (int i = 0; i < equations.length; i++) {
            String temp = equations[i];
            if (temp.charAt(1) != '=') {
                if (find(temp.charAt(0)) == find(temp.charAt(3))) return false;
            }
        }
        return true;
    }

    // 带路径压缩的查找
    public char find(char c) {
        if (parent[c - 'a'] != c) {
            parent[c - 'a'] = find(parent[c - 'a']);
        }
        return parent[c - 'a'];
    }

    // 按秩合并
    public void union(char x, char y) {
        char xroot = find(x), yroot = find(y);
        if (xroot != yroot) {
            if (rank[xroot - 'a'] <= rank[yroot - 'a']) {
                parent[xroot - 'a'] = yroot;
            }
            else {
                parent[yroot - 'a'] = xroot;
            }
            if (rank[xroot - 'a'] == rank[yroot - 'a']) rank[yroot - 'a']++;
        }
    }
}