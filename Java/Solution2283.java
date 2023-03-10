class Solution2283 {
    public boolean digitCount(String num) {
        int[] hash = new int[10];
        for (int i = 0; i < num.length(); i++) {
            int c = num.charAt(i) -'0';
            hash[c]++;
        }
        for (int i = 0; i < num.length(); i++) {
            int c = num.charAt(i) -'0';
            if (hash[i] != c) return false;
        }
        return true;
    }
}