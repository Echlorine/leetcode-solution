class Solution921 {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else {
                if (left == 0) res++;
                else left--;
            }
        }
        return res + left;
    }
}