class Solution161 {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        int sp = 0, tp = 0;
        boolean flag = false;
        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
                tp++;
            }
            else {
                if (flag) return false;
                else {
                    flag = true;
                    if (s.length() == t.length()) {
                        sp++;
                        tp++;
                    }
                    else if (s.length() < t.length()) {
                        tp++;
                    }
                    else {
                        sp++;
                    }
                }
            }
        }
        return (s.length() == t.length() && flag) || s.length() != t.length();
    }
}