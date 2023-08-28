class Solution834 {
    private int[] len; // 以某个节点作为根的子树到所有子树所有节点的路径总和
    private int[] size; // 以某个节点作为根的子树包含的节点数

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // 构建邻接表
        List<Integer>[] adjacencyList = new List[n];
        for (int[] edge : edges) {
            if (adjacencyList[edge[0]] == null) adjacencyList[edge[0]] = new ArrayList<>();
            if (adjacencyList[edge[1]] == null) adjacencyList[edge[1]] = new ArrayList<>();
            adjacencyList[edge[0]].add(edge[1]);
            adjacencyList[edge[1]].add(edge[0]);
        }
        // 确定以 0 为根的各子树的距离
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            len = new int[n];
            size = new int[n];
            dfs(adjacencyList, i, -1);
            dp[i] = len[i];
        }
        return dp;
    }

    public void dfs(List<Integer>[] adjacencyList, int root, int pre) {
        len[root] = 0;
        size[root] = 0;
        if (adjacencyList[root] == null) return;
        for (int t : adjacencyList[root]) {
            if (t == pre) continue;
            dfs(adjacencyList, t, root);
            len[root] += len[t];
            size[root] += size[t];
            size[root] += 1;
        }
        len[root] += size[root];
    }
}

class Solution {
    private int[] len; // 以某个节点作为根的子树到所有子树所有节点的路径总和
    private int[] size; // 以某个节点作为根的子树包含的节点数
    private int[] dp;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // 构建邻接表
        List<Integer>[] adjacencyList = new List[n];
        for (int[] edge : edges) {
            if (adjacencyList[edge[0]] == null) adjacencyList[edge[0]] = new ArrayList<>();
            if (adjacencyList[edge[1]] == null) adjacencyList[edge[1]] = new ArrayList<>();
            adjacencyList[edge[0]].add(edge[1]);
            adjacencyList[edge[1]].add(edge[0]);
        }
        // 确定以 0 为根的各子树的距离
        len = new int[n];
        size = new int[n];
        dp = new int[n];
        dfs(adjacencyList, 0, -1);
        dfsDp(adjacencyList, 0, -1);
        return dp;
    }

    public void dfs(List<Integer>[] adjacencyList, int root, int pre) {
        len[root] = 0;
        size[root] = 1;
        if (adjacencyList[root] == null) return;
        for (int t : adjacencyList[root]) {
            if (t == pre) continue;
            dfs(adjacencyList, t, root);
            len[root] += len[t] + size[t];
            size[root] += size[t];
        }
    }

    public void dfsDp(List<Integer>[] adjacencyList, int root, int pre) {
        System.out.println(len[root]);
        dp[root] = len[root];
        if (adjacencyList[root] == null) return;
        for (int t : adjacencyList[root]) {
            if (t == pre) continue;
            // 换根操作
            len[root] -= len[t] + size[t];
            size[root] -= size[t];
            len[t] += len[root] + size[root];
            size[t] += size[root];
            dfsDp(adjacencyList, t, root);
            // 换根的回溯
            len[t] -= len[root] + size[root];
            size[t] -= size[root];
            len[root] += len[t] + size[t];
            size[root] += size[t];
        }
    }
}