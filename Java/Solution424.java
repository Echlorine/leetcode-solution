class Solution424 {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int left = 0;
        int maxcount = 0, res = 0;
        for (int right = 0; right < s.length(); right++) { // 右边界右移
            int index = s.charAt(right) - 'A';
            hash[index]++;
            maxcount = Math.max(maxcount, hash[index]);
            int num = right - left + 1 - maxcount;
            if (num <= k) {
                res = Math.max(res, right - left + 1);
            }
            // 左边界右移
            else {
                index = s.charAt(left) - 'A';
                hash[index]--;
                left++;
            }
        }
        return res;
    }
}