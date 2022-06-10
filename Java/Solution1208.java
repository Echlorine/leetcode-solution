class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = 0, res = 0;
        int cost = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) { // 右边界右移
            int temp = Math.abs(s.charAt(right) - t.charAt(right));
            if (cost + temp <= maxCost) {
                cost += temp;
                len++;
            }
            else { // 左边界右移，同时保持右边界不变
                res = Math.max(res, len);
                int diff = Math.abs(s.charAt(left) - t.charAt(left));
                cost -= diff;
                left++;
                len--;
                right--;
            }
        }
        return Math.max(res, len);
    }
}