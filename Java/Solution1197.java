class Solution1197 {
    private int[][] dirs = new int[][] {
            new int[] {1, 2},
            new int[] {2, 1},
            new int[] {2, -1},
            new int[] {1, -2},
            new int[] {-1, -2},
            new int[] {-2, -1},
            new int[] {-2, 1},
            new int[] {-1, 2},
    };
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        int n = Math.max(x, y) + 3;
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Integer> dis = new HashMap<>();
        PriorityQueue<int[]> values = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        // Dijkstra算法
        values.offer(new int[] {2 * n + 2, 0});
        while (!values.isEmpty()) {
            int[] t = values.poll();
            visited.put(t[0], true);
            if (t[0] == (x + 2) * n + y + 2) return t[1];
            int t_x = t[0] / n, t_y = t[0] % n;
            if (dis.getOrDefault(t[0], Integer.MAX_VALUE) < t[1]) continue;
            for (int[] dir : dirs) {
                if (t_x + dir[0] < 0 || t_y + dir[1] < 0) continue;
                int loc = (t_x + dir[0]) * n + t_y + dir[1];
                if (visited.getOrDefault(loc, false)) continue;
                if (dis.getOrDefault(loc, Integer.MAX_VALUE) > t[1] + 1) {
                    dis.put(loc, t[1] + 1);
                    values.offer(new int[] {loc, t[1] + 1});
                }
            }
        }
        return -1;
    }
}