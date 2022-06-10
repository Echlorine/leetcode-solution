class Solution76 {
    public String minWindow(String s, String t) {
        int[] counts = new int[128];
        int count = 0, len = Integer.MAX_VALUE;
        String res = "";
        // 计数 t 字符串
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i);
            counts[index]--;
            if (counts[index] == -1) count++;
        }
        // 滑动窗口
        int left = 0;
        for (int right = 0; right < s.length(); right++) { // 窗口右移
            int index = s.charAt(right);
            if (count > 0) {
                if (++counts[index] == 0) count--;
            }
            if (count == 0) { // 窗口左移，同时保持右边界不变
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                index = s.charAt(left);
                if (--counts[index] < 0) count++; // 表示某个需要匹配的字符缺少了
                left++;
                if (count == 0) right--;
            }
        }
        return res;
    }
}