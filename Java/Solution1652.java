class Solution1652 {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] res = new int[len];
        if (k == 0) {
            for (int i = 0; i < len; i++) {
                res[i] = 0;
            }
        } else if (k > 0) {
            for (int i = 0; i < k; i++) {
                res[0] += code[(i+1) % len];
            }
            int st = 1, end = k;
            for (int i = 1; i < len; i++) {
                res[i] = res[i - 1] + code[++end % len] - code[st++];
            }
        } else {
            for (int i = 0; i > k; i--) {
                res[0] += code[(len + i - 1) % len];
            }
            int st = len - 1, end = len + k;
            for (int i = 1; i < len; i++) {
                res[i] = res[i - 1] + code[(++st + len) % len] - code[end++ % len];
            }
        }
        return res;
    }
}