class Solution1654 {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int f : forbidden) {
            set.add(f);
            max = Math.max(max, f);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        Map<Integer, Integer> visited = new HashMap<>();
        if (set.contains(x)) return -1;
        queue.offer(new int[] {0, 0, 0});
        visited.put(0, 0);
        if (a > b) max = x + b;
        else if (a < b) max = Math.max(max + a + b, x);
        else max = x;
        // BFS
        while(!queue.isEmpty()) {
            int[] t = queue.poll();
            if (t[0] == x) return t[1];
            // 可以右移，左移
            if (t[0] + a <= max && !set.contains(t[0] + a)) {
                if (!visited.containsKey(t[0] + a) || visited.get(t[0] + a) == 1) {
                visited.put(t[0] + a, 0);
                queue.offer(new int[] {t[0] + a, t[1] + 1, 0});
                }
            }
            if (t[2] == 0 && t[0] - b > 0 && t[0] - b <= max && !set.contains(t[0] - b)) {
                if (!visited.containsKey(t[0] - b) || visited.get(t[0] - b) == 0) {
                    visited.put(t[0] - b, 1);
                    queue.offer(new int[] {t[0] - b, t[1] + 1, 1});
                }
            }
        }
        return -1;
    }
}