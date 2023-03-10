class Solution2299 {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        Set<Character> set = new HashSet<>(){{
            add('!'); add('@'); add('#'); add('$'); add('%'); add('^');
            add('&'); add('*'); add('('); add(')'); add('-');add('+');
        }};
        int upper = 0, lower = 0, num = 0, special = 0;
        char last= password.charAt(0);
        for (int i = 0; i < password.length(); i++) {
            char cur = password.charAt(i);
            if (cur >= 'a' && cur <= 'z') lower++;
            if (cur >= 'A' && cur <= 'Z') upper++;
            if (cur >= '0' && cur <= '9') num++;
            if (set.contains(cur)) special++;
            if (i >= 1 && cur == last) return false;
            last = cur;
        }
        return lower > 0 && upper > 0 && num > 0 && special > 0;
    }
}