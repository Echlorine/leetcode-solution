class Solution50 {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double res = myPow(x, n / 2);
        if (n % 2 == 0) res = res * res;
        else {
            if (n > 0) res =  res * res * x;
            if (n < 0) res =  res * res / x;
        }
        return res;
    }

    public double Pow(double x, long n) {
        // 迭代解法
        double res = 1;
        double temp = x;
        while (n > 0) {
            if (n % 2 == 1)
                res *= temp;
            temp = temp * temp;
            n /= 2;
        }
        return res;
    }
}