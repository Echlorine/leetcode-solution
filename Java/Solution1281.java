class Solution1281 {
    public int subtractProductAndSum(int n) {
        int add = 0, mul = 1;
        while (n > 0) {
            int t = n % 10;
            n /= 10;
            add += t;
            mul *= t;
        }
        return mul - add;
    }
}