class Solution461 {
    public int hammingDistance(int x, int y) {
        // 计算异或运算结果中 1 的数量
        int n = x ^ y;
        int nums = 0;
        while (n > 0) {
            n &= (n - 1);
            nums++;
        }
        return nums++;
    }
}