class Solution874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int len = 0;
        int[][] dirs = new int[][] {
                new int[] {0, 1},
                new int[] {1, 0},
                new int[] {0, -1},
                new int[] {-1, 0}
        };
        // 存储所有出现的障碍点
        Set<Integer> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] * 60001 + obstacle[1]);
        }
        int x = 0, y = 0, d = 0; // 初始位置及朝向
        // 模拟每一步的操作
        for (int command : commands) {
            if (command == -1) {
                d = (d + 5) % 4;
            } else if (command == -2) {
                d = (d + 3) % 4;
            } else {
                int[] dir = dirs[d];
                for (int i = 0; i < command; i++) {
                    int t1 = x + dir[0], t2 = y + dir[1];
                    if (set.contains(t1 * 60001 + t2)) break;
                    x = t1;
                    y= t2;
                }
                len = Math.max(x * x + y * y, len);
            }
        }
        return len;
    }
}