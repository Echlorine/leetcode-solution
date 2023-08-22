class Solution1015 {
    public int smallestRepunitDivByK(int k) {
        int len = 1, remainder = 1 % k;
        Set<Integer> set = new HashSet<>();
        while (remainder != 0) {
            set.add(remainder);
            int t = remainder * 10 + 1;
            remainder = t % k;
            ++len;
            if (set.contains(remainder)) {
                return -1;
            }
        }
        return len;
    }
}