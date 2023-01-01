class Solution2351 {
    public char repeatedCharacter(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            hash[index]++;
            if (hash[index] > 1) return s.charAt(i);
        }
        return '\n';
    }
}