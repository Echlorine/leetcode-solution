class Solution917 {
    public String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (ischar(cs[left]) && ischar(cs[right])) { // 交换
                char temp = cs[right];
                cs[right] = cs[left];
                cs[left] = temp;
                left++;
                right--;
            }
            if (!ischar(cs[left])) left++;
            if (!ischar(cs[right])) right--;
        }
        return String.valueOf(cs);
    }

    public boolean ischar(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) return true;
        return false;
    }
}