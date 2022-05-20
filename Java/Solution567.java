import java.util.*;

class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        String sre = new String(chars);
        int left = 0, right = left + s1.length();
        while (right <= s2.length()) {
            if (equal(sre, s2.substring(left, right))) return true;
            else {
                left++;
                right++;
            }
        }
        return false;
    }

    public boolean equal(String str1, String str2) {
        char[] chars = str2.toCharArray();
        // 对字符数组按照字母顺序排序
        Arrays.sort(chars);
        // 将排序好的字符数组转成字符串
        String key = new String(chars);
        return str1.equals(key);
    }
}