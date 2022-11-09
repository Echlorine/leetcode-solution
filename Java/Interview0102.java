class Solution0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] hash = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            int c1 = s1.charAt(i), c2 = s2.charAt(i);
            hash[c1]++;
            hash[c2]--;
        }
        for (int i = 0; i < 128; i++) {
            if (hash[i] != 0) return false;
        }
        return true;
    }
}