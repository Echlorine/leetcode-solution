class Solution1427 {
    public String stringShift(String s, int[][] shift) {
        int n = 0;
        for (int[] num : shift) {
            if (num[0] == 0) n -= num[1];
            else n += num[1];
        }
        if (n % s.length() == 0) return s;
        else if (n > 0) {
            n %= s.length();
            return s.substring(s.length() - n) + s.substring(0, s.length() - n);
        }
        else {
            n = Math.abs(n) % s.length();
            return s.substring(n) + s.substring(0, n);
        }
    }
}