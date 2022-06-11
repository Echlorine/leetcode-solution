import java.util.*;

class Solution1306 {
    public boolean canReach(int[] arr, int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[arr.length];
        // 入队
        queue.offer(start);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            visited[index] = true;
            if (arr[index] == 0) return true;
            if (index + arr[index] < arr.length && !visited[index + arr[index]]) queue.offer(index + arr[index]);
            if (index - arr[index] >= 0 && !visited[index - arr[index]]) queue.offer(index - arr[index]);
        }
        return false;
    }
}