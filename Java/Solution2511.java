class Solution2511 {
    public int captureForts(int[] forts) {
        int res = 0;
        int last = -1;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 0) continue;
            if (forts[i] == -1) {
                if (last != -1) {
                    res = Math.max(res, i - last - 1);
                    last = -1;
                }
            } else {
                last = i;
            }
        }
        last = forts.length;
        for (int i = forts.length - 1; i >= 0; i--) {
            if (forts[i] == 0) continue;
            if (forts[i] == -1) {
                if (last != forts.length) {
                    res = Math.max(res, last - i - 1);
                    last = forts.length;
                }
            } else {
                last = i;
            }
        }
        return res;
    }
}