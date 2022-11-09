import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class Solution2204 {
    public int[] distanceToCycle(int n, int[][] edges) {
        // 邻接表
        List<List<Integer>> adjacentList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacentList.add(new ArrayList<>());
        }
        // 度数组
        int[] degrees = new int[n];
        for (int[] edge : edges) {
            adjacentList.get(edge[0]).add(edge[1]);
            adjacentList.get(edge[1]).add(edge[0]);
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        // 将度为1的结点入栈
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                stack.addLast(i);
            }
        }
        // 拓扑排序
        boolean[] visited = new boolean[n];
        while (!stack.isEmpty()) {
            int j = stack.removeLast();
            visited[j] = true;
            for (int k : adjacentList.get(j)) {
                if (!visited[k]) {
                    degrees[k]--;
                    if (degrees[k] == 1) {
                        stack.addLast(k);
                    }
                }
            }
        }
        // BFS 求最短路径
        stack.clear();
        Arrays.fill(visited, false);
        int[] res = new int[n];
        // 环内节点入队
        for (int i = 0; i < n; i++) {
            if (degrees[i] > 1) {
                stack.addLast(i);
                visited[i] = true;
                res[i] = 0;
            }
        }
        while (!stack.isEmpty()) {
            int j = stack.removeFirst();
            visited[j] = true;
            for (int k : adjacentList.get(j)) {
                if (!visited[k]) {
                    stack.addLast(k);
                    res[k] = res[j] + 1;
                    visited[k] = true;
                }
            }
        }
        return res;
    }
}