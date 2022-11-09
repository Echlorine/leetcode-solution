class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int up = 0, down = 0;
        while(up < word1.length() && down < word2.length()) {
            sb.append(word1.charAt(up));
            sb.append(word2.charAt(down));
            up++;
            down++;
        }
        if (up < word1.length()) {
            sb.append(word1.substring(up, word1.length()));
        }
        if (up < word2.length()) {
            sb.append(word2.substring(down, word2.length()));
        }
        return sb.toString();
    }
}