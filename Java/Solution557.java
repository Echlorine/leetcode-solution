class Solution557 {
    public String reverseWords(String s) {
        char[] sarr = s.toCharArray();
        int index = 0;
        for (int i = 0; i <= sarr.length; i++) {
            if (i == sarr.length || sarr[i] == ' ') {
                int left = index, right = i - 1;
                while (left < right) {
                    char temp = sarr[left];
                    sarr[left] = sarr[right];
                    sarr[right] = temp;
                    left++;
                    right--;
                }
                index = i + 1;
            }
        }
        return new String(sarr);
    }
}