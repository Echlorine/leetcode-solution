class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int flag = n - 1;
        return (flag & n) == 0;
    }
}