class Solution1784 {
    public boolean checkOnesSegment(String s) {
        boolean flag1 = false, flag2 = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (!flag1) flag1 = true;
                else {
                    if (!flag2) continue;
                    else return false;
                }
            } else {
                if (!flag1) continue;
                else {
                    if (!flag2) {flag2 = true; continue;}
                }
            }
        }
        return true;
    }
}