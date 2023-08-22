class Solution831 {
    public String maskPII(String s) {
        if (s.contains("@")) {
            return maskMail(s);
        }
        return maskTel(s);
    }

    public String maskMail(String s) {
        s = s.toLowerCase();
        int loc = s.indexOf('@');
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append("*****");
        sb.append(s.charAt(loc - 1));
        sb.append(s.substring(loc, s.length()));
        return sb.toString();
    }

    public String maskTel(String s) {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (len < 4) sb.append(c);
                len++;
            }
        }
        sb.append("-***-***");
        for (int i = 0; i < len - 10; i++) {
            if (i == 0) sb.append('-');
            sb.append('*');
        }
        if (len > 10) sb.append('+');
        return sb.reverse().toString();
    }
}