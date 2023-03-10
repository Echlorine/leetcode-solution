class Solution2309 {
    public String greatestLetter(String s) {
        int[] hash = new int[52];
        char res = 'A' - 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                hash[c - 'A']++;
                if (hash[c - 'A' + 26] > 0) res = c > res ? c : res;
            } else if ( c >= 'a' && c <= 'z') {
                hash[c - 'a' + 26]++;
                if (hash[c - 'a'] > 0) res = 'A' + c - 'a' > res ? (char) (c + 'A' - 'a') : res;
            }
        }
        return res == 'A' - 1 ? "" : String.valueOf(res);
    }
}