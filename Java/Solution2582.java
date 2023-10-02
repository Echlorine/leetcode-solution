class Solution2582 {
    public int passThePillow(int n, int time) {
        int loop = (n - 1) * 2;
        int r = time % loop;
        return r >= n - 1 ? loop + 1 - r : r + 1;
    }
}