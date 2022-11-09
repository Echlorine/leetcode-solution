class Solution1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int num = 0;
        int[] hash = new int[26];
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                num++;
                hash[c1[i] - 'a']++;
                hash[c2[i] - 'a']--;
            }
        }
        if (num != 0 && num != 2) return false;
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) return false;
        }
        return true;
    }
}