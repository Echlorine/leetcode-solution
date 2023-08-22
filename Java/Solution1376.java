class Solution1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        boolean[] visited = new boolean[n];
        for (int m : manager) {
            if (m == -1 || visited[m]) continue;
            int t = 0;
            while (m != -1) {
                visited[m] = true;
                t += informTime[m];
                m = manager[m];
            }
            res = Math.max(res, t);
        }
        return res;
    }
}