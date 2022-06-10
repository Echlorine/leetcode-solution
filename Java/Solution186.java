class Solution186 {
    public void reverseWords(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        left = 0;
        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                right = i - 1;
                while (left < right) {
                    char temp = s[left];
                    s[left] = s[right];
                    s[right] = temp;
                    left++;
                    right--;
                }
                left = i + 1;
            }
        }
    }
}