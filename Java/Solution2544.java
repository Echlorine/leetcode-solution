class Solution2544 {
    public int alternateDigitSum(int n) {
        // 从低到高
        int even = 0, odd = 0;
        int i = 0;
        while (n > 0) {
            int t = n % 10;
            if (i == 0) odd += t;
            else even += t;
            i ^= 1;
            n /= 10;
        }
        // 根据 i 的值判断符号
        if (i == 0) return even - odd;
        else return odd - even;
    }
}