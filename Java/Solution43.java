class Solution43 {
    public String multiply(String num1, String num2) {
        String res = "0";
        if (num1.equals("0") || num2.equals("0")) return res;
        int n = num1.length();
        for (int i = 0; i < n; i++)
            res = stringadd(res, strmultiply(num2, num1.substring(n - i - 1, n - i), i));
        return res;
    }

    public String strmultiply(String str, String num, int index) {
        // 一个自然数对应的字符串与一个 0~9 内的自然数相乘
        if (num.equals("0")) return "0";
        int multiplier = num.charAt(0) - '0';
        int product = 0;
        int cur = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= str.length(); i++) {
            product = (str.charAt(str.length() - i) - '0') * multiplier + cur;
            cur = product / 10;
            product %= 10;
            sb.insert(0, product);
        }
        if (cur != 0) sb.insert(0, cur);
        for (int i = 0; i < index; i++) {
            sb.append("0");
        }
        return sb.toString();
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