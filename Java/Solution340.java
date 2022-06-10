class Solution340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] counts = new int[128]; // 记录每个ASCII码字符的数目
        int count = 0, res = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            if (count <= k) {
                // 窗口右移
                int index = s.charAt(right++);
                counts[index]++;
                if (counts[index] == 1) count++;
                if (count <= k) res = Math.max(res, right - left);
            }
            else if (right - left > k){
                // 窗口左移
                int index = s.charAt(left++);
                counts[index]--;
                if (counts[index] == 0) count--;
            }
            else break;
        }
        return res;
    }
}