class Solution1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] stones = new int[] {a, b ,c};
        Arrays.sort(stones);
        int diff1 = stones[1] - stones[0], diff2 = stones[2] - stones[1];
        int min_res = 0, max_res = 0;
        if (diff1 == 1 && diff2 == 1) return new int[] {min_res, max_res};
        if (diff1 <= 2 || diff2 <= 2) return new int[] {1, diff1 + diff2 - 2};
        return new int[] {2, diff1 + diff2 - 2};
    }
}