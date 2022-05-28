class Solution1400 {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        int[] hash = new int[26];
        int odd = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            hash[index]++;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] % 2 == 1) odd++;
        }
        return odd <= k;
    }
}