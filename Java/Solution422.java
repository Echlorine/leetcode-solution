class Solution422 {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (word.length() > i) sb.append(word.charAt(i));
            }
            if (!sb.toString().equals(words.get(i))) return false;
        }
        return true;
    }
}