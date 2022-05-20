class Solution306 {
    public boolean isAdditiveNumber(String num) {
        boolean res = false;
        if (num.length() < 3 ) return res;
        for (int i = 1; i < num.length() / 2 + 1; i++) { // 第一个数的位置
            if (num.charAt(0) == '0' && i != 1) // 除了0，首数字不能为0
                break;
            for (int j = 1; j < num.length() / 2 + 1; j++) { // 第二个数的位置
                if (num.charAt(i) == '0' && j != 1) // 除了0，首数字不能为0
                    break;
                res = res || dfs(num, 0, i , j);
                if (res) return res;
            }
        }
        return false;
    }

    public boolean dfs(String s, int start, int mid, int len) {
        String target = stringadd(s.substring(start, mid), s.substring(mid, mid + len));
        int dif = target.length();
        String res = "";
        if (mid + len + dif <= s.length())
            res = s.substring(mid + len, mid + len + dif);
        if (res.equals(target) && mid + len + dif == s.length())
            return true;
        if (res.equals(target))
            return dfs(s, mid, mid + len, dif);
        return false;
    }

    public String stringadd(String str1, String str2) {
        int len = Math.max(str1.length(), str2.length());
        int sum = 0;
        int cur = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= len; i++) {
            int s1 = 0, s2 = 0;
            if (str1.length() - i >= 0)
                s1 = str1.charAt(str1.length() - i) - '0';
            if (str2.length() - i >= 0)
                s2 = str2.charAt(str2.length() - i) - '0';
            sum = s1 + s2 + cur;
            cur = sum / 10;
            sum %= 10;
            str.insert(0, sum);
        }
        if (cur != 0) str.insert(0, cur);
        return str.toString();
    }
}