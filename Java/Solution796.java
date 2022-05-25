class Solution796 {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if (goal.length() != n) return false;
        int index = 0;
        boolean res = false;
        while (index < n) {
            if (goal.charAt(index) == s.charAt(0))
                res = res || checkrorate(s, goal, index, n);
            if (res) return res;
        }
        return false;
    }

    public boolean checkrorate(String s, String goal, int index, int n) {
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt((i + index) % n)) return false;
        }
        return true;
    }
}