class Solution1059 {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] inValues = new int[n];
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        // 用邻接表表示反图
        for (int[] edge : edges) {
            adjacencyList.get(edge[1]).add(edge[0]);
            inValues[edge[0]]++;
        }
        if (inValues[destination] != 0) return false;
        if (source != destination && inValues[source] == 0) return false;
        // 拓扑排序
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(destination);
        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (int adj : adjacencyList.get(t)) {
                inValues[adj]--;
                if (inValues[adj] == 0) queue.offer(adj);
            }
        }
        return inValues[source] == 0;
    }
}

class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        // 用邻接表表示图
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
        }
        if (adjacencyList.get(destination).size() > 0) return false;
        int[] visited = new int[n];
        dfs(adjacencyList, visited, source, destination);
        if (visited[destination] != 2 || visited[source] != 2) return false;
        return true;
    }

    public void dfs(List<List<Integer>> adjacencyList, int[] visited, int index, int des) {
        if (visited[index] == 1) return;
        visited[index] = 1;
        boolean flag = true;
        for (int t : adjacencyList.get(index)) {
            if (visited[t] == 0) {
                dfs(adjacencyList, visited, t, des);
            }
            if (visited[t] == 1) {
                flag = false;
                break;
            }
        }
        if (adjacencyList.get(index).size() == 0 && index != des) flag = false; // 路径终点不是 des
        if (flag) visited[index] = 2;
    }
}