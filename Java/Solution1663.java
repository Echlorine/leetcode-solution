class Solution1663 {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int upper = 26 * n, lower = 26 * (n - 1), remain = k;
        for (int i = 1; i <= n; i++) {
            char cur = 'a';
            if (remain - 1 > lower) cur += remain - 1 - lower;
            sb.append(cur);
            remain -= cur - 'a' + 1;
            upper -= 26;
            lower -= 26;
        }
        return sb.toString();
    }
}