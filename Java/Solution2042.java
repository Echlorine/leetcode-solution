class Solution2042 {
    public boolean areNumbersAscending(String s) {
        int last = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int cur = 0;
                while (i < s.length() && c >= '0' && c <= '9') {
                    cur = 10 * cur + c - '0';
                    i++;
                    if (i < s.length()) c = s.charAt(i);
                }
                if (last >= cur) return false;
                last = cur;
            }
        }
        return true;
    }
}