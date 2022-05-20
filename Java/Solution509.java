class Solution509 {
    public int fib(int n) {
        int first = 0;
        if (n == 0) return first;
        int second = 1;
        if (n == 1) return second;
        int res = first + second;
        for (int i = 2; i <= n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
        // 下面是记忆化递归的方法
        // int[] res = new int[n + 1];
        // return recursion_fib(n, res);
    }

    public int recursion_fib(int n, int[] res) {
        if (n == 0) {
            res[0] = 0;
            return res[n];
        }
        if (n == 1) {
            res[1] = 1;
            return res[n];
        }
        if (res[n]!=0) // 记忆化递归
            return res[n];
        res[n] = recursion_fib(n - 1, res) + recursion_fib(n - 2, res);
        return res[n];
    }
}