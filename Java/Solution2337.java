class Solution2337 {
    public boolean canChange(String start, String target) {
        char[] s = start.toCharArray(), t = target.toCharArray();
        for (int first = 0, second = 0; first < s.length; first++, second++) {
            char a = s[first];
            char b = t[second];
            if (a == b) continue;
            if (a == 'R' && b == '_') {
                while (first < s.length && s[first] != '_') {
                    if (s[first] == 'L') return false;
                    first++;
                }
                if (first < s.length) {
                    s[first] = 'R';
                    s[second] = '_';
                } else {
                    return false;
                }
            } else if (a == '_' && b == 'L') {
                while (first < s.length && s[first] != 'L') {
                    if (s[first] == 'R') return false;
                    first++;
                }
                if (first < s.length) {
                    s[first] = '_';
                    s[second] = 'L';
                } else {
                    return false;
                }
            } else {
                return false;
            }
            first = second;
        }
        return true;
    }
}