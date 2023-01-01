class Solution {
    public int secondHighest(String s) {
        int[] hash = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                hash[c - '0']++;
            }
        }
        int num = 0;
        for (int i = 9; i >= 0; i--) {
            if (hash[i] > 0) num++;
            if (num == 2) return i;
        }
        return -1;
    }
}