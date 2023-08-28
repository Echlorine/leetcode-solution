class Solution1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 用邻接表表示图
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        // 从 source 进行 DFS 遍历
        boolean[] visited = new boolean[n];
        visited[source] = true;
        dfs(source, visited, adjacencyList);
        return visited[destination];
    }
    
    public void dfs(int source, boolean[] visited, List<List<Integer>> adjacencyList) {
        for (int i : adjacencyList.get(source)) {
            if (visited[i]) continue;;
            visited[i] = true;
            dfs(i, visited, adjacencyList);
        }
    }
}