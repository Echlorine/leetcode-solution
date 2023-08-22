class Solution {
    public String addStrings(String num1, String num2) {
        int t = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            int a1 = 0, a2 = 0;
            if (i < num1.length()) a1 = num1.charAt(num1.length() - 1 - i) - '0';
            if (i < num2.length()) a2 = num2.charAt(num2.length() - 1 - i) - '0';
            int temp = a1 + a2 + t;
            t = temp / 10;
            sb.append(temp % 10);
        }
        if (t > 0) sb.append(t);
        return sb.reverse().toString();
    }
}