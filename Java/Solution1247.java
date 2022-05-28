class Solution1247 {
    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;
        int len = s1.length();
        int x = 0, y = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') x++;
                else y++;
            }
        }
        if ((x + y) % 2 == 1) return -1;
        return (x + y) / 2 + (x % 2);
    }
}