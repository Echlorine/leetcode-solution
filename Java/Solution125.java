class Solution125 {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char cleft = s.charAt(left), cright = s.charAt(right);
            if (!Character.isDigit(cleft) && !ischar(cleft)) {
                left++;
                continue;
            }
            if (!Character.isDigit(cright) && !ischar(cright)) {
                right--;
                continue;
            }
            if (ischar(cleft)) cleft = Character.toLowerCase(cleft);
            if (ischar(cright)) cright = Character.toLowerCase(cright);
            if (cleft != cright) return false;
            left++;
            right--;
        }
        return true;
    }

    public boolean ischar(char c) {
        boolean res = false;
        res = res || (c >= 'a' && c <= 'z');
        res = res || (c >= 'A' && c <= 'Z');
        return res;
    }
}