class Solution2500 {
    public int deleteGreatestValue(int[][] grid) {
        PriorityQueue<Integer>[] grids = new PriorityQueue[grid.length];
        for (int i = 0; i < grid.length; i++) {
            grids[i] = new PriorityQueue<>();
            for (int j = 0; j < grid[i].length; j++) {
                grids[i].offer(grid[i][j]);
            }
        }
        // 每次拿出最大值
        int res = 0;
        while (!grids[0].isEmpty()) {
            int ans = 0;
            for (int i = 0; i < grids.length; i++) {
                ans = Math.max(ans, grids[i].poll());
            }
            res += ans;
        }
        return res;
    }
}