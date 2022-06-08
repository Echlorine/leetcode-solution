class Solution680 {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            else return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
        }
        return true;
    }

    public boolean isPalindrome(String s, int start, int end) {
        int left = start, right = end;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}