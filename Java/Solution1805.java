class Solution1805 {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int begin = i;
            while (isInteger(c) && i < word.length()) {
                if (begin == i && c == '0') {
                    // 特例
                    if (i + 1 < word.length() && !isInteger(word.charAt(i + 1))) set.add("0");
                    else if (i + 1 < word.length()) begin++;
                }
                i++;
                if (i < word.length()) c = word.charAt(i);
            }
            if (begin < i) set.add(word.substring(begin, i));
        }
        return set.size();
    }

    public boolean isInteger(char c) {
        if (c >= '0' &&  c <= '9') return true;
        return false;
    }
}