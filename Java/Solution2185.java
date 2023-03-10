class Solution2185 {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < pref.length()) continue;
            boolean flag = true;
            for (int j = 0; j < words[i].length() && j < pref.length(); j++) {
                if (words[i].charAt(j) != pref.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) res++;
        }
        return res;
    }
}