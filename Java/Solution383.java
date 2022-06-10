class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] rhash = new int[26];
        int[] mhash = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            if (i < ransomNote.length()) {
                int index = ransomNote.charAt(i) - 'a';
                rhash[index]++;
            }
            int index = magazine.charAt(i) - 'a';
            mhash[index]++;
        }
        for (int i = 0; i < 26; i++) {
            if (rhash[i] > mhash[i]) return false;
        }
        return true;
    }
}