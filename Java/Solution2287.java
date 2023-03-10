class Solution2287 {
    public int rearrangeCharacters(String s, String target) {
        int[] hasht = new int[26];
        int[] hashs = new int[26];
        for (int i = 0; i < target.length(); i++) {
            hasht[target.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (hasht[index] != 0) hashs[index]++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (hasht[i] != 0) res = Math.min(res, hashs[i] / hasht[i]);
        }
        return res;
    }
}