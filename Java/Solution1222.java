class Solution1222 {
    private int[][] dirs = new int[][] {
            new int[] {-1, 0},
            new int[] {-1, 1},
            new int[] {0, 1},
            new int[] {1, 1},
            new int[] {1, 0},
            new int[] {1, -1},
            new int[] {0, -1},
            new int[] {-1, -1},
    };

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] values = new int[8][8];
        for (int[] queen : queens) {
            values[queen[0]][queen[1]] = 1;
        }
        // 找 8 个方向的最近元素
        List<List<Integer>> res = new ArrayList<>();
        for (int[] dir : dirs) {
            int x = king[0], y = king[1];
            while (x + dir[0] >= 0 && x + dir[0] < 8 && y + dir[1] >= 0 && y + dir[1] < 8) {
                if (values[x][y] == 1) break;
                x += dir[0];
                y += dir[1];
            }
            List<Integer> ans = new ArrayList<>();
            ans.add(x);
            ans.add(y);
            if (values[x][y] == 1) res.add(ans);
        }
        return res;
    }
}