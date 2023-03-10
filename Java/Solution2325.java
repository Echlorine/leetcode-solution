class Solution2325 {
    public String decodeMessage(String key, String message) {
        char[] hash = new char[26];
        int num = 0;
        for (int i = 0; i < key.length() && num < 26; i++) {
            char t = key.charAt(i);
            if (t == ' ' || hash[t - 'a'] != 0) continue;
            else {
                hash[t - 'a'] = (char) ('a' + num);
                num++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') sb.append(' ');
            else sb.append(hash[message.charAt(i) - 'a']);
        }
        return sb.toString();
    }
}