public class offer10_I {
    public int fib(int n) {
        int mod = 1000000007;
        int first = 0;
        if (n == 0) return first;
        int second = 1;
        if (n == 1) return second;
        int res = first + second;
        for (int i = 2; i <= n; i++) {
            res = (first + second) % mod;
            first = second;
            second = res;
        }
        return res;
    }
}