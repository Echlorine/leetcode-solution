class Solution806 {
    public int[] numberOfLines(int[] widths, String s) {
        int temp = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            temp += widths[s.charAt(i) - 'a'];
            if (temp > 100) {
                len++;
                temp = 0;
                i--;
            }
        }
        return new int[] {len + 1, temp};
    }
}