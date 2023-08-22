class Solution1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs.length() % 5 != 0) return -1;
        int[] hash = new int[4];
        Map<Character, Integer> map = new HashMap<>() {{
            put('c', 0);
            put('r', 1);
            put('o', 2);
            put('a', 3);
        }};
        int res = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            if (c != 'k') {
                hash[map.get(c)]++;
                // hash 数组应该是逐渐递减的
                int t = hash[0];
                for (int j = 1; j < 4; j++) {
                    if (hash[j] > t) return -1;
                    t = hash[j];
                }
            } else {
                int t = hash[0];
                res = Math.max(res, t);
                for (int j = 0; j < 4; j++) {
                    hash[j]--;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            if (hash[i] > 0) return -1;
        }
        return res;
    }
}