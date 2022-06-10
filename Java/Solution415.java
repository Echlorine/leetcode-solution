class Solution415 {
    public String addStrings(String num1, String num2) {
        int len = Math.max(num1.length(), num2.length());
        int sum = 0;
        int cur = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= len; i++) {
            int s1 = 0, s2 = 0;
            if (num1.length() - i >= 0)
                s1 = num1.charAt(num1.length() - i) - '0';
            if (num2.length() - i >= 0)
                s2 = num2.charAt(num2.length() - i) - '0';
            sum = s1 + s2 + cur;
            cur = sum / 10;
            sum %= 10;
            str.insert(0, sum);
        }
        if (cur != 0) str.insert(0, cur);
        return str.toString();
    }
}