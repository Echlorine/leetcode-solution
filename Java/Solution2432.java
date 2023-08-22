class Solution2432 {
    public int hardestWorker(int n, int[][] logs) {
        int last = 0;
        int min_id = 0, max_time = 0;
        for (int[] log : logs) {
            int t = log[1] - last;
            last = log[1];
            if (t > max_time) {
                min_id = log[0];
                max_time = t;
            }
            else if (t == max_time) min_id = Math.min(min_id, log[0]);
        }
        return min_id;
    }
}