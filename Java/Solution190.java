class Solution190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int t = n >> i & 1;
            res = res | (t << (31 - i));
        }
        return res;
    }
}