class Solution1017 {
    public String baseNeg2(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int radix = -2;
        while(n != 0) {
            if (n % radix == 0) {
                sb.append(0);
            } else {
                int t = n % radix;
                if (t < 0) t += Math.abs(radix);
                sb.append(t);
                n -= t;
            }
            n /= radix;
        }
        return sb.reverse().toString();
    }
}