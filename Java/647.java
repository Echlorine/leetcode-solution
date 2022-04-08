class Solution647 {
    public int countSubstrings(String s) {
        // 枚举回文中心
        int len = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            len = 0;
            // 回文中心为奇数
            while (i - len >= 0 && i + len < s.length()) {
                if (s.charAt(i - len) == s.charAt(i + len)) {res++; len++;}
                else break;
            }
            // 回文中心为偶数
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                len = 0;
                while (i - len >= 0 && i + 1 + len < s.length()) {
                    if (s.charAt(i - len) == s.charAt(i + 1 + len)) {res++; len++;}
                    else break;
                }
            }
        }
        return res;
    }
}