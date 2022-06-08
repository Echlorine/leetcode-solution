class Solution541 {
    public String reverseStr(String s, int k) {
        char[] sarr = s.toCharArray();
        int diff = s.length() % (2 * k);
        int len = s.length() - diff;
        for (int i = 0; i < s.length(); i += 2 * k) {
            int left = i, right = left;
            if (diff < k && i >= len) {
                right = s.length() - 1;
            }
            else {
                right = left + k - 1;
            }
            while (left < right) {
                char temp = sarr[left];
                sarr[left] = sarr[right];
                sarr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(sarr);
    }
}