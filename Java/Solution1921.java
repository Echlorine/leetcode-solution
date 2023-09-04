class Solution1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] time = new int[dist.length];
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            int t = dist[i] % speed[i] == 0 ? 0 : 1;
            time[i] = dist[i] / speed[i] + t;
        }
        Arrays.sort(time);
        for (int i = 0; i < time.length; i++) {
            if(time[i] >= i + 1) res++;
            else break;
        }
        return res;
    }
}