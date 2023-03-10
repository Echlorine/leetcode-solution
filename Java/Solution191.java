class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n >> i & 1;
            if (temp == 1) res++;
        }
        return res;
    }
}