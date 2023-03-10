class Solution2315 {
    public int countAsterisks(String s) {
        boolean flag = false;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!flag) { // 目前不在连续对中
                if (c == '*') res++;
                else if (c == '|') flag = true;
                else continue;
            } else { // 目前在连续对中
                if (c == '|') flag = false;
                else continue;
            }
        }
        return res;
    }
}