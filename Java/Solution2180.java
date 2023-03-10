class Solution2180 {
    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            if (isEven(i)) res++;
        }
        return res;
    }

    public boolean isEven(int n) {
        int res = 0;
        while (n >= 10) {
            res += n % 10;
            n /= 10;
        }
        res += n;
        return res % 2 == 0;
    }
}